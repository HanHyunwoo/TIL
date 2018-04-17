package com.example.student.p554;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.ImageView;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service onStartCommand", Toast.LENGTH_SHORT).show();

        if (intent==null){
            return Service.START_STICKY;
        }else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent) {
        final Intent sintent = new Intent(getApplicationContext(),MainActivity.class);
        sintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK  |
                         Intent.FLAG_ACTIVITY_SINGLE_TOP |
                         Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Runnable run = new Runnable() {

            @Override
            public void run() {
                for (int i=1;i<8;i++) {
                    sintent.putExtra("cnt", i);
                    startActivity(sintent); // startActivity: 서비스에서 액티비티로 전달

                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

        };
        new Thread(run).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
