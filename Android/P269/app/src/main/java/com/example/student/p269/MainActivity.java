package com.example.student.p269;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickBt (View v){
        Intent intent= null;

        switch (v.getId()){   // v.getId() 현재 선택된 거의 id가져오기
            case R.id.bt1:
                //매니페스트에 네트워크 권한 설정을 안하는 이유는, 브라우져를 불러오는거이기 때문에 폰에서 직접 외부로 나가는게 아니다.
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com")); //폰os의 기본 디펄트 브라우저에게 요청
                break;

            case R.id.bt2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-4567"));
                break;

                //매니페스트에 권한을 줘야함. 권한 줬음 , 매니페스트 화인, 근데
            case R.id.bt3:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1234-4567"));
                break;
        }
        startActivity(intent);
    }

}
