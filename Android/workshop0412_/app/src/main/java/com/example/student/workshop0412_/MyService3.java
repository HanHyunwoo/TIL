package com.example.student.workshop0412_;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService3 extends Service {
    private  static  final String TAG = "--- MyService3 ---";

    public MyService3() {
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
        Log.d(TAG,"Service3 processCommand ....");
        final Intent sintent = new Intent(getApplicationContext(),MainActivity.class);

        String command = intent.getStringExtra("command");
        sintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);


        Runnable run = new Runnable() {

            @Override
            public void run() {
                    sintent.putExtra("command","cmd3");
                    startActivity(sintent);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
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
