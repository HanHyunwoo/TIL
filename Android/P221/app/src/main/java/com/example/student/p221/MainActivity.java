package com.example.student.p221;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    Resources res;  //얘만 있으면 리소스에 잇는 모든 것을 가져올 수 있다. r. 은 지칭이고 얘는 가져오는 거
  //  Button bt1, bt2, bt3;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        makeui();
    }

    public void makeui(){
//        bt1 = findViewById(R.id.bt1);
//        bt2 = findViewById(R.id.bt2);
//        bt3 = findViewById(R.id.bt3);
        image = findViewById(R.id.imageView);
    }

    public void clickBt(View v){  //View 어떤 버튼이 클릭되어진건지 알고 싶다 ~
        BitmapDrawable bitmap = null;

        if (v.getId() == R.id.bt1){
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.bg4);
        }else if (v.getId() == R.id.bt2){
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.bg5);
        }else  if(v.getId() == R.id.bt3){
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.bg6);
        }
        image.setImageDrawable(bitmap);
    }
}
