package com.example.student.workshop_0410;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    LinearLayout ll1,ll2,ll3;
    TextView textView;
    EditText loginID,loginPWD ,txt_ID , txt_PWD;
    String id="";
    String pwd="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeui();
        timeStart();
    }

    public  void makeui(){
        wv = findViewById(R.id.wv);
        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);
        textView = findViewById(R.id.viewTime);

        ll1.setVisibility(View.INVISIBLE);
        ll2.setVisibility(View.INVISIBLE);
        ll3.setVisibility(View.VISIBLE);

        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);
    }

    public void joinBt(View v){
        txt_ID = findViewById(R.id.txt_ID);
        txt_PWD = findViewById(R.id.txt_PWD);
        id = txt_ID.getText().toString();
        pwd = txt_PWD.getText().toString();

        if(id!=null && !pwd.equals("")) {
            txt_ID.setText("");
            txt_PWD.setText("");
            Toast.makeText(this, "가입완료 : " + id + "     " + pwd, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "ID,PWD 입력해주세요." + pwd, Toast.LENGTH_SHORT).show();
        }

        //아래내용 안됨 확인해야함
        //Toast.makeText(this, newID.equals("") + "1" + newID.getText().equals("") + "2", Toast.LENGTH_SHORT).show();
        /*if (newID.getText().toString() == "" || newID.getText().toString() == null) {
            Toast.makeText(this, "ID를 입력하세요.", Toast.LENGTH_SHORT).show();
        }else if (id == newID.getText().toString()){
            Toast.makeText(this, newID.getText().toString() + "가 있습니다.", Toast.LENGTH_SHORT).show();
        }else{
            id = newPWD.getText().toString();
            pwd = newPWD.getText().toString();
            Toast.makeText(this, "ID "+id + "가 저장 되었습니다.", Toast.LENGTH_SHORT).show();
        }*/
    }


    public void loginbt(View v){
        loginID=findViewById(R.id.txt_ID2);
        loginPWD=findViewById(R.id.txt_PWD2);

        String testid = loginID.getText().toString();
        String testpw = loginPWD.getText().toString();
        //Toast.makeText(this, id+"     "+pwd,Toast.LENGTH_SHORT).show();
        if(testid.equals(id) && testpw.equals(pwd)){
            Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"id, pw가 틀렸습니다. ", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickBt(View v){
        if (v.getId() == R.id.bt1){
            ll1.setVisibility(View.INVISIBLE);
            ll2.setVisibility(View.INVISIBLE);
            ll3.setVisibility(View.VISIBLE);

        }else if (v.getId() == R.id.bt2){
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.INVISIBLE);
            ll3.setVisibility(View.INVISIBLE);

        }else if (v.getId() == R.id.bt3){
            ll1.setVisibility(View.INVISIBLE);
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.INVISIBLE);

        }else if (v.getId() == R.id.bt4){
            wv.loadUrl("http://70.12.114.144/GOTozo/chart4.jsp");
            wv.setVisibility(View.VISIBLE);

            ll1.setVisibility(View.INVISIBLE);
            ll2.setVisibility(View.INVISIBLE);
            ll3.setVisibility(View.INVISIBLE);
        }else if (v.getId() == R.id.bt5){
            wv.loadUrl("http://m.naver.com");
            wv.setVisibility(View.VISIBLE);
            ll1.setVisibility(View.INVISIBLE);
            ll2.setVisibility(View.INVISIBLE);
            ll3.setVisibility(View.INVISIBLE);
        }
    }

    public void timeStart(){
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Calendar calendar = Calendar.getInstance();
                            int hour = calendar.get(Calendar.HOUR_OF_DAY); // 시
                            int minute = calendar.get(Calendar.MINUTE); // 분
                            int second = calendar.get(Calendar.SECOND); // 초
                            textView.setText(hour + ":" + minute + ":" + second + "\n");
                        }
                    });

                    try {
                        Thread.sleep(1000); // 1000 ms = 1초
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } // while
            } // run()
        }; // new Thread() { };
        thread.start();
    }


}
