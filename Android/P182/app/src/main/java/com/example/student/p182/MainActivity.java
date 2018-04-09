package com.example.student.p182;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    LinearLayout Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Aclick(View v){
        text = findViewById(R.id.text);
        text.setTextColor(Color.RED);

        Layout = findViewById(R.id.lay);
        Layout.setBackgroundResource(R.drawable.bg2);

    }

    public void Bclick(View v){
        text = findViewById(R.id.text);
        text.setTextColor(Color.BLUE);

        Layout = findViewById(R.id.lay);
        Layout.setBackgroundResource(R.drawable.bg3);
    }

    public void Cclick(View v){
        text = findViewById(R.id.text);
        text.setTextColor(Color.CYAN);

        Layout = findViewById(R.id.lay);
        Layout.setBackgroundResource(R.drawable.bg4);
    }

    public void Dclick(View v){
        text = findViewById(R.id.text);
        text.setTextColor(Color.YELLOW);

        Layout = findViewById(R.id.lay);
        Layout.setBackgroundColor(Color.CYAN);
    }

    public void Eclick(View v){
        text = findViewById(R.id.text);
        text.setTextColor(Color.GRAY);

        Layout = findViewById(R.id.lay);
        Layout.setBackgroundColor(Color.YELLOW);
    }

    public void Fclick(View v){
        text = findViewById(R.id.text);
        text.setTextColor(Color.MAGENTA);

        Layout = findViewById(R.id.lay);
        Layout.setBackgroundColor(Color.GRAY);
    }


}
