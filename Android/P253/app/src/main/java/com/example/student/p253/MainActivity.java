package com.example.student.p253;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    LayoutInflater inflater;  //LayoutInflater : XML에 정의된 Resource(자원)들을 View의 형태로 반환해준다.

     //inflater 컨테이너에다가 무언가를 붙일려면 필요한 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeui();
    }

    private void makeui() {
        container = findViewById(R.id.container);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void clickBt(View v){
//        View v1 =
//                inflater.inflate(R.layout.sub,container,true); //R.layout.sub를 container(레이아웃)에 붙이겟습니다.
//        TextView stv = v1.findViewById(R.id.stv);

        inflater.inflate(R.layout.sub,container,true); //R.layout.sub를 container(레이아웃)에 붙이겟습니다.
        TextView stv = findViewById(R.id.stv);
        stv.setText("Button Click");
        Button sbt1 = container.findViewById(R.id.sbt1);
        Button sbt2 = container.findViewById(R.id.sbt2);
        sbt1.setText("sub Button 1");
        sbt2.setText("sub Button 2");

        sbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sub2 변경
                inflater.inflate(R.layout.sub,container,false);
                inflater.inflate(R.layout.sub2,container,true);

                Toast.makeText(MainActivity.this, "바껴라", Toast.LENGTH_SHORT).show();
            }
        });

        sbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sub2 변경
            }
        });


    }
}
