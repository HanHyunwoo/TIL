package com.example.student.p246;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Resources res;
    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();

        imageView1 = findViewById(R.id.view1);
        imageView2 = findViewById(R.id.view2);
    }

    public void clickBt(View v){
        BitmapDrawable bitmap = null;

        if (v.getId() == R.id.bt1){
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.bg4);
            imageView1.setImageDrawable(bitmap);
            imageView2.setImageDrawable(null);

        }else if (v.getId() == R.id.bt2){
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.bg4);
            imageView2.setImageDrawable(bitmap);
            imageView1.setImageDrawable(null);

        }
    }

}
