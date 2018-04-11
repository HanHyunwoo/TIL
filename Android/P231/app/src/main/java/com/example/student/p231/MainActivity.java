package com.example.student.p231;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2;
    RadioButton rb1, rb2;
    Switch switch1;
    ToggleButton toggleButton;
    RadioGroup rbGroup;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeui();
    }

    public void makeui(){
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        switch1 = findViewById(R.id.switch1);
        toggleButton = findViewById(R.id.toggleButton);
        rbGroup = findViewById(R.id.rbGroup);
        editText = findViewById(R.id.editText);


        //어나니머스 클래스
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str = editText.getText().toString();
                Toast.makeText(MainActivity.this, i  + " " + +i1 + " " + i2 + " " + str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        //어나니머스 클래스, 괄호안에 이름 없는 클래스를 만들어주는 방법
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "결과:" + b, Toast.LENGTH_SHORT).show();
                if (b==true){
                    rb1.setVisibility(View.VISIBLE);
                    rb2.setVisibility(View.VISIBLE);
                }else {
                    rb1.setVisibility(View.INVISIBLE);
                    rb2.setVisibility(View.INVISIBLE);
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // radio 그룹
                if (b==true){
                    rbGroup.setVisibility(View.INVISIBLE);
                }else {
                    rbGroup.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void clickBt(View v){
        String str ="";
        if(cb1.isChecked()){
            str += "공부";
        }
        if (cb2.isChecked()){
            str += "잠자기";
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void clickBt2(View v){
        String str = "";
        if(rb1.isChecked()){
            str = "남자";
        }else if (rb2.isChecked()){
            str = "여자";
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}
