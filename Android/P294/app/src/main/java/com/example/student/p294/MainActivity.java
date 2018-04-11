package com.example.student.p294;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Date date = new Date();
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        sp = getSharedPreferences("pref", Activity.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        restoreState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        saveState();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
//    }

    public void saveState(){  // 사용자정의 함수임
        int rcnt = sp.getInt("cnt",0);
        SharedPreferences.Editor editor =  sp.edit();   // SharedPreferences.Editor :edit를 사용하기 위한 객체
        editor.putInt("cnt",++rcnt);
        editor.putString("date",date.toString());
        editor.commit();
    }

    public void restoreState(){  // 사용자정의 함수임
        if(sp != null){
            if(sp.contains("cnt") && sp.contains("date")){
                String rdate = sp.getString("date","");
                int rcnt = sp.getInt("cnt",0);
                Toast.makeText(this, rcnt + " ", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  // this :현재 액티비티(판때기), 현재 나의 메인 액티비티 위에다가 다이얼로그를 띄우겟다
        builder.setTitle("Alert Message !!");
        builder.setMessage("Are you want to exit & clear?");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor editor =  sp.edit();
                editor.putInt("cnt",0);
                //editor.clear();
                editor.commit();
                finish();
            }
        });
        builder.show();
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
//    }
//
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }


}
