package com.example.student.p213;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {

    TextView ok_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ok_id = findViewById(R.id.ok_id);

        Intent intent = getIntent();
        String id = intent.getStringExtra("LoginID");
        ok_id.setText(id);

    }
}
