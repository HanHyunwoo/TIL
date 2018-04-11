package com.example.student.p290;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView thirdTx;
    int num1;

//RequestCode는 101로 셋팅한다.
//num1을 받아서 *2000을 한 후 , MainActivity에게 결과를 보내고, 종료한다.
//MainActivity에서는 결과를 받아서 화면에 출력한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        thirdTx = findViewById(R.id.thirdTx);

        Intent intent = getIntent();
        num1 = intent.getIntExtra("num1",0);
        thirdTx.setText(num1+ "");
    }

    public void clickBt(View v){
        int result = num1 *2000;
        Intent intent = new Intent();
        intent.putExtra("result",result);
        setResult(RESULT_OK,intent); // RESULT_OK응답코드로 200,
        finish();
    }
}
