package com.nabieh.mostafa.project;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.track;
import static android.R.attr.x;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Activity myActivity;
  static   boolean check=true;
    spinnerthread threadstart;
    int Id;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myActivity=this;
        Toast.makeText(this,  "ازايك عامل اية" ,Toast.LENGTH_LONG).show();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        spinner =(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.arr,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){Id=1;}
                if(position==1){Id=2;}
                if(position==2){Id=3;}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void bustop(View view) {

        threadstart=new spinnerthread(0);
        try{
        check=false;

            Toast.makeText(this, "انت تامر تم الايقاف" ,Toast.LENGTH_LONG).show();
    }catch (Exception e){}}
    public void bustart(View view) {
        check=true;
        try {
            if(Id==1){


                    threadstart=new spinnerthread(30000);
                    threadstart.start();



            }
            if(Id==2){
                threadstart=new spinnerthread(45000);
                threadstart.start();
            }
            if(Id==3){
                threadstart=new spinnerthread(60000);
                threadstart.start();
            }

        }catch (Exception e){
            Toast.makeText(this,"فى حاجة غلط",Toast.LENGTH_LONG).show();}
    }



    class spinnerthread extends Thread{
        private  long time;

        public spinnerthread(int time){
            this.time=time;
        }

        public void run(){
        final   MediaPlayer  Audio  =MediaPlayer.create(myActivity,R.raw.m);
            while (check){
                myActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Audio.start();
                    }

                });
                try {
                    Thread.sleep(time);
                }catch (Exception e){}
            }


        }
    }
    }


