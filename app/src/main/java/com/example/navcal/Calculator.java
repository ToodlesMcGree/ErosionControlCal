package com.example.navcal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TextView result, rbag, resultTank, tankLoad, sqFtTank, projName;
    EditText number1, number2, number3, number4, number5, projectName;
    Button clear, add;

    double result_num, bagT, result_num2, tankT2;
    double num1, num2, num3, num4, num5, tankSqFt;
    double acre = 43560 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        drawerLayout = findViewById(R.id.drawer_layout);

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
        projName = findViewById(R.id.projName);
        projectName = findViewById(R.id.projectName);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1.getText().clear();
                number2.getText().clear();
                number3.getText().clear();
                number4.getText().clear();
                number5.getText().clear();
                projectName.getText().clear();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(number1.getText().toString());//total size
                num2 = Double.parseDouble(number2.getText().toString());//mulch app
                num3 = Double.parseDouble(number3.getText().toString());//bag weight
                num4 = Double.parseDouble(number4.getText().toString());//tank size
                num5 = Double.parseDouble(number5.getText().toString());//mulch mixing rate

                //total much needed for project
                result_num = (num2 * (num1/acre));//double acre = 43560 ;
                bagT = (result_num / num3 * 10) / 10;//bags

                //total tank loads needed for project
                result_num2= (num4 * num5) /100/ num3;//bags per tank
                tankT2= (float)Math.round(bagT/result_num2 *100)/100;//tank load
                tankSqFt = num1/tankT2;//sq ft/tank

                //output text project name
                projName.setText("Project Name: " + projectName.getText().toString());

                //output text total mulch needed for project
                result.setText(String.format("%.2f",result_num)+ " lbs of mulch");
                rbag.setText(String.format("%.2f", bagT)+" bags");

                //output text total tank loads needed for project
                resultTank.setText(String.format("%.2f", result_num2)+ "  bags per tank");
                tankLoad.setText(String.format("%.2f", tankT2)+ "  tank loads");
                sqFtTank.setText(String.format("%.2f", tankSqFt)+ " sq ft/tank");
            }
        });


    }
    public void ClickMenu(View view) {
        //open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //redirect activity to home
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickCalculator(View view){
        MainActivity.redirectActivity(this,Calculator.class);
    }

    public void ClickCalculator2(View view) {
        //redirect activity to Cal2
        MainActivity.redirectActivity(this, Calculator2.class);
    }

    public void ClickHistory(View view) {
        //redirect activity to History
        MainActivity.redirectActivity(this, History.class);
    }

    public void ClickDashboard(View view){
        //redirect activity to Dashboard
        MainActivity.redirectActivity(this,Dashboard.class);
    }


    public void ClickAbout(View view){
        //redirect activity to about us
        MainActivity.redirectActivity(this,AboutUs.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }


}