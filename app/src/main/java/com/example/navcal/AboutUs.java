package com.example.navcal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
    //initialize var
    DrawerLayout drawerLayout;
    private TextView textOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        //assign var
        drawerLayout = findViewById(R.id.drawer_layout);

        textOut = (TextView) findViewById(R.id.textView2);

        textOut.setText("This is Team 7's version of a HydroMulch calculator for their CSC 131 client sponsored project." +
                " Team 7 consists of 3 students from Sacramento State majoring in Computer Science and hoping to gain experience from this project." +
                " The client that sponsored this project was CalTrans and provided guidelines to create an erosion control calculator for construction use.\n" +
                "\n" +
                "CalTrans, also known as the California Department of Transportation, needed an app that can create an estimate of the amount of mulch and tank loads needed for their finished construction sites. " +
                "They are trying to use this information to keep track of the materials used and to help make it easier to calculate for their workers so that they can provide sufficient erosion control in their finished construction sites.");

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

    public void ClickDashboard(View view){
        //redirect activty to dash
        MainActivity.redirectActivity(this,Dashboard.class);

    }

    public void ClickCalculator(View view) {
        //recreate activty
        MainActivity.redirectActivity(this, Calculator.class);
    }

    public void ClickCalculator2(View view) {
        //recreate activty
        MainActivity.redirectActivity(this, Calculator2.class);
    }

    public void ClickHistory(View view) {
        //recreate activty
        MainActivity.redirectActivity(this, History.class);
    }

    public void ClickAbout(View view){
        MainActivity.redirectActivity(this, AboutUs.class);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}