package com.example.student.server;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Client client;
        client = new Client();

        try {
            client.startClient();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class Client {

        boolean flag = true;
        String address = "192.168.0.54";
        Socket socket;
        boolean cflag = true;

        public Client() {
            while (cflag) {
                try {

                    Log.d("------","ready");
                    socket = new Socket(address, 9999);
                    cflag = false;
                    Log.d("------","ready1");

                    break;

                } catch (IOException e) {


                    try {

                        Thread.sleep(1000);

                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                }
            }

        }


        public void startClient() throws Exception {

            new Receiver(socket).start();

            Sender sender = new Sender(socket);


            while (flag != false) {


                String str = "abcabc";
                if (str.trim().equals("q")) {

                    Thread t = new Thread(sender);

                    sender.setSendMsg("q");

                    t.start();
                    flag = false;
                    break;

                }

                Thread t = new Thread(sender);

                sender.setSendMsg(str);

                t.start();

            }
            Thread.sleep(1000);

            socket.close();

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

                while (inr != null) {

                    try {

                        String str = inr.readUTF();

                        System.out.println(str);

                        if (str.trim().equals("q")) {

                            inr.close();

                            break;

                        }

                    } catch (Exception e) {
                        break;
                    }
                }

                try {

                    Thread.sleep(1000);

                    flag = false;

                    socket.close();

                    System.exit(0);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }
    }
}
