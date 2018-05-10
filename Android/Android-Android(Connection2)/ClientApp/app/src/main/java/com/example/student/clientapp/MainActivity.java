package com.example.student.clientapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText speed;
    ImageView imageView;

    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speed = findViewById(R.id.speed);
        imageView = findViewById(R.id.imageView);
        client = new Client();
        client.start();

    }


    public void click(View v){

        String msg = speed.getText().toString();
        client.sendMsg(msg);


    }

    public void convertImg(final String str){
        Runnable r = new Runnable(){

            @Override
            public void run() {

                runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        if(str.equals("1")){
                            imageView.setImageResource(R.drawable.car1);
                        }else if(str.equals("2")){
                            imageView.setImageResource(R.drawable.car2);
                        }else if(str.equals("3")){
                            imageView.setImageResource(R.drawable.car3);
                        }

                    }
                });

            }
        };
        new Thread(r).start();
    }

    //Client socket Start...

    public class Client extends Thread {

        String address = "192.168.0.35";
        Socket socket;
        boolean cflag = true;
        boolean flag = true;

        public Client() {

        }

        @Override
        public void run() {

            while (cflag) {
                try {
                    Log.d("[Client App]","TRY Connecting Server.. ");
                    socket = new Socket(address, 8888);
                    Log.d("[Client App]","Connected Server.. ");
                    cflag = false;
                    break;
                } catch (IOException e) {
                    Log.d("[Client App]","retry.. ");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }

            }

            // After Connected..
            try {
                new Receiver(socket).start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void sendMsg(String msg) {
            try {
                Sender sender = new Sender(socket);
                sender.setSendMsg(msg);
                new Thread(sender).start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        class Sender implements Runnable {

            Socket socket;
            OutputStream out;
            DataOutputStream outw;
            String sendMsg;

            public Sender(Socket socket) throws IOException {

                this.socket = socket;
                out = socket.getOutputStream();
                outw = new DataOutputStream(out);

            }

            public void setSendMsg(String sendMsg) {
                this.sendMsg = sendMsg;

            }

            @Override
            public void run() {
                try {
                    if (outw != null) {
                        outw.writeUTF(sendMsg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        class Receiver extends Thread {
            Socket socket;
            InputStream in;
            DataInputStream inr;

            public Receiver(Socket socket) throws IOException {
                this.socket = socket;
                in = socket.getInputStream();
                inr = new DataInputStream(in);
            }

            @Override
            public void run() {
                try {
                    while (flag && inr != null) {

                        String str = inr.readUTF();
                        Log.d("[Client app]",str);
                        convertImg(str);

                    }
                } catch (Exception e) {

                }finally {
                    if(inr != null) {
                        try {
                            inr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }

        public void stopClient() {

            try {
                Thread.sleep(1000);
                flag = false;
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    //Client socket end...


    @Override
    protected void onDestroy() {
        super.onDestroy();
        client.stopClient();
    }
}