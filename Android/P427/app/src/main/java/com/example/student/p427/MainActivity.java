package com.example.student.p427;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    WebView webView;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new JS(),"js");  //js클래스 등록~!

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        handler = new Handler();

    }

    public void clickBt(View v) {
        webView.loadUrl("http://70.12.114.143/ad/sample.html");
    }

    public void clickBt2(View v) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:changeImg()");
            }
        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                webView.loadUrl("javascript:changeImg()");
//            }
//        });;
    }


    final class JS{  //사용할려면 js클래스 등록을 해야 한다!
        JS(){}
        @android.webkit.JavascriptInterface //애플리케이션에서 정의한 메소드를 웹페이지에서 호출할 때 사용해야 함
        public  void clickJS(String i){
            textView.setText(i+ "");
            Log.d("[ js ] " , "Event Process ...." + i);
            Toast.makeText(MainActivity.this, i + "", Toast.LENGTH_SHORT).show();
        }
    }


}


