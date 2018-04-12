package com.example.student.workshop0412_;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    LinearLayout ll;
    ProgressDialog progressDialog;
    EditText editText;
    Intent intent,intent3;
    ProgressBar progressBar;
    ImageView imageView;

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if(intent != null){
            String command = intent.getStringExtra("command");
            int cnt = intent.getIntExtra("cnt",0);

            String service3 = intent3.getStringExtra("service3");


//            if (cnt %2 ==1){
//                imageView.setImageResource(R.drawable.bg3);
//            }else{
//                imageView.setImageResource(R.drawable.bg4);
//            }

            progressBar.setProgress(cnt*10);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.ll1);
        ll.setVisibility(View.INVISIBLE);  // 숨기기
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressDialog =new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);

    }


    public void clickBt(View v){

        if (v.getId() == R.id.bt1){

            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("진행중");
            //progressDialog.show();
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (ll.getVisibility() == View.INVISIBLE){
                ll.setVisibility(View.VISIBLE);
            }else {
                ll.setVisibility(View.INVISIBLE);
            }
            //progressDialog.dismiss();
        }


        else if(v.getId() == R.id.bt2){
            //MyService
            intent = new Intent(this,MyService.class);
            intent.putExtra("command","start");
            startService(intent);


            //MyService3
            intent3 = new Intent(this,MyService3.class);
            intent3.putExtra("command","start");
            startService(intent3);


            Toast.makeText(this, "Start2 누름", Toast.LENGTH_SHORT).show();
        }

    }


}
