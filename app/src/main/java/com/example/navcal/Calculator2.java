package com.example.navcal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculator2 extends AppCompatActivity {

    private Spinner sp1;
    private EditText editText;
    private TextView textOut0, textOut1, textOut2, textOut3;
    private Button button;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);

        //Initialization
        editText = (EditText) findViewById(R.id.editTextNumber);
        textOut0 = (TextView) findViewById(R.id.textView12);
        textOut1 = (TextView) findViewById(R.id.textView13);
        textOut2 = (TextView) findViewById(R.id.textView14);
        textOut3 = (TextView) findViewById(R.id.textView15);
        button = (Button) findViewById(R.id.button);
        sp1 = (Spinner) findViewById(R.id.sp1);
        drawerLayout = findViewById(R.id.drawer_layout);


        String[] unitConversion = {"lb", "kg", "ton(metric)", "oz", "gram"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                unitConversion);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        NumberFormat formatter = new DecimalFormat("0.###E0");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                //convertNumber();
                String userInput = editText.getText().toString();
                double input = Double.parseDouble(userInput);
                double result;

                if(sp1.getSelectedItem().toString() == "lb"){

                    double[] array = {0.452592, 453.592, 0.000453592, 16};

                    for(int i = 0; i < 4; i++) {

                        result = input * array[i];

                        String length = "" + result;
                        String[] split = length.split("\\.");

                        if(i == 0){
                            if(split[0].length() + split[1].length() > 8){

                                textOut0.setText(String.format("%9.3E", result) + " kg");

                            }
                            else{
                                textOut0.setText("" + result + " kg");
                            };
                        }
                        else if(i == 1){
                            if(split[0].length() + split[1].length() > 8){

                                textOut1.setText(String.format("%9.3E", result) + " gram");

                            }
                            else{
                                textOut1.setText("" + result + " gram");
                            };
                        }
                        else if(i == 2){
                            if(split[0].length() + split[1].length() > 8){

                                textOut2.setText(String.format("%9.3E", result) + " ton");

                            }
                            else{
                                textOut2.setText("" + result + " ton");
                            };
                        }
                        else if(i == 3){
                            if(split[0].length() + split[1].length() > 8){

                                textOut3.setText(String.format("%9.3E", result) + " oz");

                            }
                            else{
                                textOut3.setText("" + result + " oz");
                            };
                        }
                    }

                }

                else if(sp1.getSelectedItem().toString() == "kg"){

                    double[] array = {2.2046, 1000, 0.001, 35.274};

                    for(int i = 0; i < 4; i++) {

                        result = input * array[i];

                        String length = "" + result;
                        String[] split = length.split("\\.");

                        if(i == 0){
                            if(split[0].length() + split[1].length() > 8){

                                textOut0.setText(String.format("%9.3E", result) + " lb");

                            }
                            else{
                                textOut0.setText("" + result + " lb");
                            }
                        }
                        else if(i == 1){
                            if(split[0].length() + split[1].length() > 8){

                                textOut1.setText(String.format("%9.3E", result) + " gram");

                            }
                            else{
                                textOut1.setText("" + result + " gram");
                            }
                        }
                        else if(i == 2){
                            if(split[0].length() + split[1].length() > 8){

                                textOut2.setText(String.format("%9.3E", result) + " ton");

                            }
                            else{
                                textOut2.setText("" + result + " ton");
                            }
                        }
                        else if(i == 3){
                            if(split[0].length() + split[1].length() > 8){

                                textOut3.setText(String.format("%9.3E", result) + " oz");

                            }
                            else{
                                textOut3.setText("" + result + " oz");
                            }
                        }
                    }

                }

                else if(sp1.getSelectedItem().toString() == "oz"){

                    double[] array = {0.0625, 28.3495, 35274, 0.0283495};

                    for(int i = 0; i < 4; i++) {

                        if(array[i] == 35274) {

                            result = input / array[i];

                        }
                        else{
                            result = input * array[i];
                        }
                        String length = "" + result;
                        String[] split = length.split("\\.");

                        if(i == 0){
                            if(split[0].length() + split[1].length() > 8){

                                textOut0.setText(String.format("%9.3E", result) + " lb");

                            }
                            else{
                                textOut0.setText("" + result + " lb");
                            }
                        }
                        else if(i == 1){
                            if(split[0].length() + split[1].length() > 8){

                                textOut1.setText(String.format("%9.3E", result) + " gram");

                            }
                            else{
                                textOut1.setText("" + result + " gram");
                            }
                        }
                        else if(i == 2){
                            if(split[0].length() + split[1].length() > 8){

                                textOut2.setText(String.format("%9.3E", result) + " ton");

                            }
                            else{
                                textOut2.setText("" + result + " ton");
                            }
                        }
                        else if(i == 3){
                            if(split[0].length() + split[1].length() > 8){

                                textOut3.setText(String.format("%9.3E", result) + " kg");

                            }
                            else{
                                textOut3.setText("" + result + " kg");
                            }
                        }
                    }

                }

                else if(sp1.getSelectedItem().toString() == "gram"){

                    double[] array = {0.00220462, 0.001, 0.000001, 0.035274};

                    for(int i = 0; i < 4; i++) {

                        result = input * array[i];

                        String length = "" + result;
                        String[] split = length.split("\\.");

                        if(i == 0){
                            if(split[0].length() + split[1].length() > 8){

                                textOut0.setText(String.format("%9.3E", result) + " lb");

                            }
                            else{
                                textOut0.setText("" + result + " lb");
                            }
                        }
                        else if(i == 1){
                            if(split[0].length() + split[1].length() > 8){

                                textOut1.setText(String.format("%9.3E", result) + " kg");

                            }
                            else{
                                textOut1.setText("" + result + " kg");
                            }
                        }
                        else if(i == 2){
                            if(split[0].length() + split[1].length() > 8){

                                textOut2.setText(String.format("%9.3E", result) + " ton");

                            }
                            else{
                                textOut2.setText("" + result + " ton");
                            }
                        }
                        else if(i == 3){
                            if(split[0].length() + split[1].length() > 8){

                                textOut3.setText(String.format("%9.3E", result) + " oz");

                            }
                            else{
                                textOut3.setText("" + result + " oz");
                            }
                        }
                    }

                }

                else if(sp1.getSelectedItem().toString() == "ton(metric)"){

                    double[] array = {2204.62, 1000, 1000000, 35274};

                    for(int i = 0; i < 4; i++) {

                        result = input * array[i];

                        String length = "" + result;
                        String[] split = length.split("\\.");

                        if(i == 0){
                            if(split[0].length() + split[1].length() > 8){

                                textOut0.setText(String.format("%9.3E", result) + " lb");

                            }
                            else{
                                textOut0.setText("" + result + " lb");
                            }
                        }
                        else if(i == 1){
                            if(split[0].length() + split[1].length() > 8){

                                textOut1.setText(String.format("%9.3E", result) + " kg");

                            }
                            else{
                                textOut1.setText("" + result + " kg");
                            }
                        }
                        else if(i == 2){
                            if(split[0].length() + split[1].length() > 8){

                                textOut2.setText(String.format("%9.3E", result) + " gram");

                            }
                            else{
                                textOut2.setText("" + result + " gram");
                            }
                        }
                        else if(i == 3){
                            if(split[0].length() + split[1].length() > 8){

                                textOut3.setText(String.format("%9.3E", result) + " oz");

                            }
                            else{
                                textOut3.setText("" + result + " oz");
                            }
                        }
                    }

                }

                else{

                    result = input;

                    String length = "" + result;
                    String[] split = length.split("\\.");

                    if(split[0].length() + split[1].length() > 8){

                        textOut0.setText(String.format("%9.3E", result));

                    }
                    else{
                        textOut0.setText("" + result);
                    };

                }

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
        MainActivity.redirectActivity(this, Calculator.class);
    }

    public void ClickCalculator2(View view){
        MainActivity.redirectActivity(this, Calculator2.class);
    }


    public void ClickHistory(View view) {
        //recreate activity
        MainActivity.redirectActivity(this, History.class);
    }


    public void ClickDashboard(View view){
        //recreate activity
        MainActivity.redirectActivity(this,Dashboard.class);

    }
    public void ClickAbout(View view){
        //redirect activity to about us
        MainActivity.redirectActivity(this,AboutUs.class);

    }




    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
}