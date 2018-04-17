package com.example.student.p555;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    MyTask myTask;
    Button button;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        progressDialog = new ProgressDialog(MainActivity.this);  //getApplicationContext : 메인액티비티에서 프로그래스바를 띄우겠습니다

        myTask = new MyTask("192.168.111.100");
    }

    public void clickBt(View v){
        myTask = new MyTask("192.168.111.100");  //이거 한줄 넣어줌으로써 클릭버튼 2번 눌러도 됨
        myTask.execute();
        Log.d("click........","@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

//        try {
//            int result = myTask.execute().get();
//            Log.d("click........",result +"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }

    //AsyncTask : 쓰레드라고 생각해도 좋아, 쓰레드가 시작전,후,진행중에도 무언가를 할 수가 있다.
    class MyTask extends AsyncTask<String,Integer,Integer>{    //첫번째 String : doing백그라운드 메인, 맨마지막 integer는 리턴값, 가운데는 쓰레드에서 넘겨주는 값
        String msg;

        public MyTask(){}

        public MyTask(String msg){
            this.msg = msg;
        }

        @Override
        protected void onPreExecute() {                 //쓰레드가 시작하기 전에 아래 실행,  ( ui변경이 가능하다.)
            progressBar.setMax(55);
            textView.setText("start Thread...");
            button.setEnabled(false);
            progressDialog.setTitle("Progress");
            progressDialog.setMessage("Img .....");
            progressDialog.show();
        }

        @Override
        protected Integer doInBackground(String... Strings) {       //쓰레드에서의 run부분(메인쓰레드),run부분이지만 아규먼트를 넣을 수 있다.
            //String msg = Strings[0];
            int result = 0;
            Log.d("doInBackground....",msg+"start @@@@@@@@@@@@@@@@@@@");

            for (int i = 1 ; i<=10;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result += i;
                publishProgress(result);
            }

            Log.d("doInBackground....","end @@@@@@@@@@@@@@@@@@@@@");

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer result) {     //쓰레드가 끝나면 아래 실행  ( ui변경이 가능하다.)
            textView.setText("End Thread : " + result);
            button.setEnabled(true);
            progressDialog.dismiss();
        }

    }

}
