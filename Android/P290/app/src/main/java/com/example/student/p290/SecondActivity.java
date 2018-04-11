package com.example.student.p290;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView secondTx;
    int num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondTx = findViewById(R.id.secondTx);

        Intent intent = getIntent();
        num1 = intent.getIntExtra("num1",0);
        secondTx.setText(num1+ "");
    }

    public void clickBt(View v){
        int result = num1 *3000;
        Intent intent = new Intent();
        intent.putExtra("result",result);
        setResult(RESULT_OK,intent); // RESULT_OK응답코드로 200,
        finish();
    }
}
