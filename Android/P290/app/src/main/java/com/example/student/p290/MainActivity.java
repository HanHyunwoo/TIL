package com.example.student.p290;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    @Override  //아래 인텐트 결과를 받는애
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  //Intent data : 앞에 인텐트에서 주는 것
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "" + requestCode + " " + requestCode, Toast.LENGTH_SHORT).show();
        int result = data.getIntExtra("result",0);

        if (requestCode ==100 && resultCode==RESULT_OK){
            textView.setText(result+"");
        } else if (requestCode ==101 && resultCode==RESULT_OK){
            textView.setText(result+"");
        }
    }


    public void clickBt(View v){
        if (v.getId() == R.id.bt1){
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("num1",1000);
            startActivityForResult(intent,100); //startActivity(intent); 이거를 startActivityForResult로 바꿈
        }else if (v.getId() == R.id.bt2){
            Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
            intent.putExtra("num1",1000);
            startActivityForResult(intent,101); //startActivity(intent); 이거를 startActivityForResult로 바꿈
        }
    }

}
