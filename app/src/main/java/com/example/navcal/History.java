package com.example.navcal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.Flushable;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class History extends AppCompatActivity {


    DataBasehandler dataBasehandler;
    ListView listView;

    DrawerLayout drawerLayout;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        dataBasehandler = new DataBasehandler(History.this);
        ArrayList<Model> arrayList = dataBasehandler.getAllData();
        listView = findViewById(R.id.list_view);
        ListAdapter listAdapter = new ListAdapter(getApplicationContext(),arrayList);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();


        //assign var
        drawerLayout = findViewById(R.id.drawer_layout);
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
        //redirect activity to dash
        MainActivity.redirectActivity(this,Dashboard.class);

    }

    public void ClickCalculator(View view) {
        //recreate activity
        MainActivity.redirectActivity(this, Calculator.class);
    }

    public void ClickAbout(View view){
        MainActivity.redirectActivity(this, AboutUs.class);

    }

    public void ClickHistory(View view){
        MainActivity.redirectActivity(this, History.class);

    }



    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }


}