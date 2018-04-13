package com.example.student.p425;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);  //자바스크립트 안되게 함, 예를들어 브라우져에 자바스크립 기능off



    }

    public void clickBt(View v){
        if (v.getId() == R.id.bt1){
            webView.loadUrl("https://m.naver.com");
            );
        }else if(v.getId() == R.id.bt2){
            webView.loadUrl("https://m.nate.com");
        }
    }

}
