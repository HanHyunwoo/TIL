package com.example.student.p554;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2,imageView3;
    MyHandler myHandler;
    Intent intent;
    Boolean flag;

    //R.drawable 이라는게 int형이기 때문에 int에 집어넣는다~
    int imgs [] = {R.drawable.c1,R.drawable.c2,R.drawable.c3,
                    R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        myHandler = new MyHandler();
    }

    //버튼을 클릭하면 동시에 2개의 쓰레드가 동작한다.
/*    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<7;i++){       //이미지갯수(7)만큼 폴문 돌린다.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //Image Switch 이미지 변경
                final int cnt = i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView1.setImageResource(imgs[cnt]);
                    }
                });

            }
        }
    });*/

/*    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=1;i<8;i++){       //이미지갯수(7)만큼 폴문 돌린다.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //Image Switch 이미지 변경
                Message msg = new Message();        //메시지 객체를 만들어서 번들로 이동시켰다~
                Bundle bundle = msg.getData();       //메시지 객체를 만들어서 번들로 이동시켰다~

                bundle.putInt("data",i);
                myHandler.sendMessage(msg);

            }
        }
    });*/

    Runnable r1 = new Runnable() {
        @Override
        public void run() {
                for(int i=0;i<7;i++){       //이미지갯수(7)만큼 폴문 돌린다.
                    //Image Switch 이미지 변경
                    final int cnt = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView1.setImageResource(imgs[cnt]);
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            for(int i=1;i<8;i++){       //이미지갯수(7)만큼 폴문 돌린다.
                //Image Switch 이미지 변경
                Message msg = new Message();        //메시지 객체를 만들어서 번들로 이동시켰다~
                Bundle bundle = msg.getData();       //메시지 객체를 만들어서 번들로 이동시켰다~

                bundle.putInt("data",i);
                myHandler.sendMessage(msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
    };

    class MyHandler extends Handler{            //메시지 전달방식
        @Override
        public void handleMessage(Message msg) {   //제너럴 -오버레드 메소드
            Bundle bundle = msg.getData();
            int data = bundle.getInt("data");
            switch (data){
                case 1: imageView2.setImageResource(R.drawable.c1);
                    break;
                case 2: imageView2.setImageResource(R.drawable.c2);
                    break;
                case 3: imageView2.setImageResource(R.drawable.c3);
                    break;
                case 4: imageView2.setImageResource(R.drawable.c4);
                    break;
                case 5: imageView2.setImageResource(R.drawable.c5);
                    break;
                case 6: imageView2.setImageResource(R.drawable.c6);
                    break;
                case 7: imageView2.setImageResource(R.drawable.c7);
                    break;
            }
        }
    }

    public void clickBt(View v){
        flag= true;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        intent = new Intent(this,MyService.class);
        intent.putExtra("command","start");
        startService(intent);
    }

    public void clickBt2(View v){
        //flag = false;
        //Intent intent = new Intent(this,MyService.class);
        //intent.putExtra()
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null){
            int cnt = intent.getIntExtra("cnt",0);
            imageView3.setImageResource(imgs[cnt-1]);
        }
    }



}

