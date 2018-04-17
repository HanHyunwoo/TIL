package com.example.student.p556;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText2;
    TextView textView;
    LoginTask loginTask;
    ProgressDialog progressDialog;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        loginTask = new LoginTask();

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Progress ...");
        progressDialog.setCancelable(false);    // 프로그래스다이얼로그가 끝나야 바탕 클릭할 수 있음

    }

    public void clickLogin(View v) throws ExecutionException, InterruptedException {
        loginTask = new LoginTask();
        String id = editText.getText().toString();
        String pwd = editText2.getText().toString();
        String result = "";

        //loginTask.onPreExecute();

        //result = loginTask.execute(id,pwd).get();
        loginTask.execute(id,pwd).get();

        //loginTask.onPostExecute("");

/*        if (result.equals("1")){
            textView.setText("Login OK");
        }else{
            textView.setText("Login Fail");
        }*/
    }


    class LoginTask extends AsyncTask<String,Void,String>{   //첫번째 아규먼트는 메인스레드에 넣어주는 역할, 두번째는 진행되는 와중에 업데이트로 넘겨주는 아규먼트 타입,3번째 결과를 받는 타입의 형태
        @Override
        protected void onPreExecute() {
            progressDialog.show();
            button.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            String id = strings[0];
            String pwd = strings[1];
            String result = "";

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (id.equals("qq") && pwd.equals("11")){
                result = "1";
            }else{
                result = "0";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            button.setEnabled(true);
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

            if (s.equals("1")){
                textView.setText("Login OK");

                dialog.setTitle("Alert");
                dialog.setMessage("Login OK !!!");
                dialog.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        return;
                    }
                });
                AlertDialog alert = dialog.create();
                alert.show();

            }else{
                textView.setText("Login Fail");

                dialog.setTitle("Alert");
                dialog.setMessage("Login Fail !!!");
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        editText.setText("");
                        editText2.setText("");
                        return;
                    }
                });
                AlertDialog alert = dialog.create();
                alert.show();
            }

        }
    }

}
