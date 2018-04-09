package com.example.student.p82;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeui();

    }

    public void makeui(){            //깔끔하게 사용자 정의함수로 만듬
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);

//        bt2.setEnabled(false);
//        bt3.setEnabled(false);
//        bt4.setEnabled(false);

//        bt2.setVisibility(View.INVISIBLE);
//        bt3.setVisibility(View.INVISIBLE);
//        bt4.setVisibility(View.INVISIBLE);
    }


    public void clickstartbt (View v){
//        bt2.setEnabled(true);
//        bt3.setEnabled(true);
//        bt4.setEnabled(true);

//        bt2.setVisibility(View.VISIBLE);
//        bt3.setVisibility(View.VISIBLE);
//        bt4.setVisibility(View.VISIBLE);
    }

    public void clickbt1 (View v){
        setContentView(R.layout.activity_second);
    }

    public void clickbt2 (View v){
        setContentView(R.layout.activity_third);
    }

    public void clickbt3 (View v){
        setContentView(R.layout.activity_fourth);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();
    }
}
