package com.example.student.workshop0412_;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private  static  final String TAG = "--- MyService ---";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Service onCreate ....");   //로그에 TAG 붙임
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Service onStartCommand ....");
        if (intent == null){
            return Service.START_STICKY;
        }else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }


    private void processCommand(Intent intent) {
        Log.d(TAG,"Service processCommand ....");
        final Intent sintent = new Intent(getApplicationContext(),MainActivity.class);

        String command = intent.getStringExtra("command");

        // FLAG_ACTIVITY_SINGLE_TOP, FLAG_ACTIVITY_CLEAR_TOP 현재 떠있는 액티비티를 이용할 수 있따.
        sintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Runnable run = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 11; i++) {
                    sintent.putExtra("command","cmd");
                    sintent.putExtra("cnt",i);
                    startActivity(sintent);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        new Thread(run).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
