package com.example.student.workshop_0410;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Resources res;
    WebView wv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeui();
    }

    public void makeui(){

    }

    public void clickBt(View v){
        if (v.getId() == R.id.bt1){

        }else if(v.getId() == R.id.bt2){

        }else if(v.getId() == R.id.bt3){

        }else if(v.getId() == R.id.bt3) {

        }

    }



}
