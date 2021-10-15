package com.example.navcal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //initialize variable
    DataBasehandler dataBasehandler;

    DrawerLayout drawerLayout;
    TextView result, rbag, resultTank, tankLoad, sqFtTank;
    EditText number1, number2, number3, number4, number5, projectName;
    Button clear, add;

    Float result_num, bagT, result_num2, tankT2;
    Float num1, num2, num3, num4, num5, tankSqFt;
    int acre = 43560 ;
    String pro_name;


    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBasehandler = new DataBasehandler(MainActivity.this);

        //assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        projectName=findViewById(R.id.projectName);
        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        number3=findViewById(R.id.number3);
        number4=findViewById(R.id.number4);
        number5=findViewById(R.id.number5);
        result=findViewById(R.id.result);
        clear=findViewById(R.id.clear);
        add = findViewById(R.id.add);
        result = findViewById(R.id.result);
        rbag = findViewById(R.id.rBag);
        resultTank = findViewById(R.id.resultTank);
        tankLoad = findViewById(R.id.tankLoad);
        sqFtTank = findViewById(R.id.sqFeetTank);
        //projName = findViewById(R.id.projName);
        //projectName = findViewById(R.id.projectName);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectName.getText().clear();
                number1.getText().clear();
                number2.getText().clear();
                number3.getText().clear();
                number4.getText().clear();
                number5.getText().clear();
            }
        });




        add.setOnClickListener(new View.OnClickListener() {

            @SuppressLint({"DefaultLocale", "SetTextI18n", "ResourceType"})
            @Override
            public void onClick(View v) {

                //projectName.onEditorAction(EditorInfo.IME_ACTION_DONE);//hide keyboard after clicking calculate button
                number1.onEditorAction(EditorInfo.IME_ACTION_DONE);
                number2.onEditorAction(EditorInfo.IME_ACTION_DONE);
                number3.onEditorAction(EditorInfo.IME_ACTION_DONE);
                number4.onEditorAction(EditorInfo.IME_ACTION_DONE);
                number5.onEditorAction(EditorInfo.IME_ACTION_DONE);


                //num0 = getText(R.id.projectName);
                num1 = Float.parseFloat(number1.getText().toString());//total size
                num2 = Float.parseFloat(number2.getText().toString());//mulch app
                num3 = Float.parseFloat(number3.getText().toString());//bag weight
                num4 = Float.parseFloat(number4.getText().toString());//tank size
                num5 = Float.parseFloat(number5.getText().toString());//mulch mixing rate
                pro_name = projectName.getText().toString();

                //total much needed for project
                result_num = (num2 * (num1/acre));//double acre = 43560 ;
                bagT = (result_num / num3 * 10) / 10;//bags

                //total tank loads needed for project
                result_num2= (num4 * num5) /100/ num3;//bags per tank
                tankT2= (float)Math.round(bagT/result_num2 *100)/100;//tank load
                tankSqFt = num1/tankT2;//sq ft/tank

                //total much needed for project
                result_num = (num2 * (num1/acre));//double acre = 43560 ;
                bagT = (result_num / num3 * 10) / 10;//bags

                //total tank loads needed for project
                result_num2= (num4 * num5) /100/ num3;//bags per tank
                tankT2= (float)Math.round(bagT/result_num2 *100)/100;//tank load
                tankSqFt = num1/tankT2;//sq ft/tank

                //output text total mulch needed for project
                result.setText(String.format("%.2f",result_num)+ " lbs of mulch");
                rbag.setText(String.format("%.2f", bagT)+" bags");

                //output text total tank loads needed for project
                resultTank.setText(String.format("%.2f", result_num2)+ "  bags per tank");
                tankLoad.setText(String.format("%.2f", tankT2)+ "  tank loads");
                sqFtTank.setText(String.format("%.2f", tankSqFt)+ " sq ft/tank");

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                Log.d("time",""+simpleDateFormat.format(date));
                String string_result_num = String.format("%.2f",result_num);
                String string_bagT = String.format("%.2f",bagT);
                String string_result_num2 = String.format("%.2f",result_num2);
                String string_tankT2 = String.format("%.2f",tankT2);
                String string_tankSqFt = String.format("%.2f",tankSqFt);
                Log.d("pResult",string_result_num);
                Model model = new Model(string_result_num,string_bagT,string_result_num2,string_tankT2,string_tankSqFt,""+simpleDateFormat.format(date),pro_name);
                dataBasehandler.setAllData(model);
            }
        });
    }



    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);

    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickDashboard(View view){
        redirectActivity(this,Dashboard.class);

    }

    public void ClickHome(View view){
        //recreate activity
        MainActivity.redirectActivity(this, MainActivity.class);
    }
    public void ClickCalculator(View view){
        //recreate activity
        redirectActivity(this,Calculator.class);
    }




    public void ClickCalculator2(View view){
        //redirect activity to about us
        redirectActivity(this,Calculator2.class);

    }public void ClickHistory(View view) {
        //recreate activty
        MainActivity.redirectActivity(this, History.class);
    }

    public void ClickAbout(View view){
        //redirect activity to about us
        redirectActivity(this,AboutUs.class);

    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //initialize intent
        Intent intent = new Intent(activity,aClass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }

    public void caltransTool(View view){
        Intent caltransToolIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://dot.ca.gov/programs/design/lap-erosion-control-design/tool-1-lap-erosion-control-toolbox"));
        startActivity(caltransToolIntent);
    }

}