package com.example.student.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnButton1Clicked(View v){
        Toast.makeText(getApplicationContext(),"시작 버튼이 눌렀어요.",Toast.LENGTH_LONG).show();
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }
}
