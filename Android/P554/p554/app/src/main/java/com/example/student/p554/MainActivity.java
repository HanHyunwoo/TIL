package com.example.student.p554;

import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private String tag = "---Main Activity---";
    TextView txtv;
    ProgressBar prgrsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtv = findViewById(R.id.txtv);
        prgrsb = findViewById(R.id.prgrsb);
    }

    public void onClickBnt(View v) {
        int result=0;
        try {
            result = new MyAsyncTask("192.168.111.100").execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d(tag, "onClickBtn" + result);
    }

    class MyAsyncTask extends AsyncTask<String, String, Integer> {
        String msg;

        public MyAsyncTask(String msg) {
            super();
        }

        @Override
        protected void onPreExecute() {
            txtv.setText("Start AsyncTask...");
        }

        @Override
        protected Integer doInBackground(String... Strings) {
            int result = 0;
            Log.d(tag, "Start -- ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 1; i <=10; i++){
                result+=i;
            }
            Log.d(tag, "End -- ");
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            txtv.setText("End AsyncTask..." + result);
        }
    }
}
