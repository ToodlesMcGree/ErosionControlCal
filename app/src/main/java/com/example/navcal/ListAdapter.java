package com.example.navcal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Model> modelArrayList;


    public ListAdapter(Context context, ArrayList<Model> modelArrayList)
    {
        this.context=context;
        this.modelArrayList=modelArrayList;
    }
    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tv_two,tv_three,tv_five,tv_six,tv_seven,tv_time,tv_pro_name;
        Button btn_share;
        Model model = modelArrayList.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.single_history, parent, false);

        }
        tv_two = convertView.findViewById(R.id.tv_two);
        tv_three = convertView.findViewById(R.id.tv_three);
        tv_five = convertView.findViewById(R.id.tv_five);
        tv_six = convertView.findViewById(R.id.tv_six);
        tv_seven = convertView.findViewById(R.id.tv_seven);
        btn_share = convertView.findViewById(R.id.btn_share);
        tv_time = convertView.findViewById(R.id.tv_time);
        tv_pro_name = convertView.findViewById(R.id.tv_pro_name);

        tv_two.setText(String.valueOf(model.getLbs_of_mulch()) + " lbs of mulch");
        tv_three.setText(String.valueOf(model.getBags()) + " bags");
        tv_five.setText(String.valueOf(model.getBags_per_tank()) + " bags per tank");
        tv_six.setText(String.valueOf(model.getTank_loads()) + " tank loads");
        tv_seven.setText(String.valueOf(model.getSq_ft_tank()) + " sq ft/tank");
        tv_time.setText(model.getDateTime());
        tv_pro_name.setText(model.getProject_name());

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dateTime = model.getDateTime();
                String s1 = "Total Mulch Needed for Project";
                String s2 = model.getLbs_of_mulch()+ " lbs of mulch";
                String s3 = model.getBags()+ " bags";
                String s4 = "Total Tank Loads Needed for Project";
                String s5 = model.getBags_per_tank()+ " bags per tank";
                String s6 = model.getTank_loads()+ " tank loads";
                String s7 = model.getSq_ft_tank()+ " sq ft/tank";
                String s8 ="Project Name "+ model.getProject_name();
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, ""+dateTime+" \n"+s8+" \n"+s1+" \n"+s2+" \n"+s3+" \n"+s4+" \n"+s5+" \n"+s6+" \n"+s7 );

                Intent startIntent = Intent.createChooser(sharingIntent, context.getResources().getString(R.string.app_name));
                startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(startIntent);



                /*Create an ACTION_SEND Intent*/
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//                /*This will be the actual content you wish you share.*/
//                String dateTime = model.getDateTime();
//                String s1 = "Total Mulch Needed for Project";
//                String s2 = model.getLbs_of_mulch();
//                String s3 = model.getBags();
//                String s4 = "Total Tank Loads Needed for Project";
//                String s5 = model.getBags_per_tank();
//                String s6 = model.getTank_loads();
//                String s7 = model.getSq_ft_tank();
//                String s8 = model.getProject_name();
//                /*The type of the content is text, obviously.*/
//                intent.setType("text/plain");
//                /*Applying information Subject and Body.*/
//                intent.putExtra(Intent.EXTRA_TEXT,""+dateTime+" \n"+s1+" \n"+s2+" \n"+s3+" \n"+s4+" \n"+s5+" \n"+s6+" \n"+s7+" \n"+s8);
//
//                Intent shareIntent = Intent.createChooser(intent, null);
//
//                /*Fire!*/
//                context.startActivity(shareIntent);
            }
        });


        return convertView;
    }
}
