package com.example.student.proximitysensor;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;    // SensorManager : 센서를 다루기 위해 제공되는 시스템 서비스 객체
    private Sensor sensor;                   // Sensor : 센서 정보를 포함하고 있다.

    SoundPool sound = new SoundPool(1, AudioManager.STREAM_ALARM, 0);
    int streamId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE );    // 폰에 존재하는 센서목록을 가져온다.
        sensor = sensorManager.getDefaultSensor( Sensor.TYPE_PROXIMITY );   // PROXIMITY센서를 호출한다.
        //1.SENSOR_DELAY_FASTEST          0ms 최대한 빠르게
        //2.SENSOR_DELAY_GAME        20,000ms 게임에 적합한 속도
        //3.SENSOR_DELAY_UI          60,000ms UI 수정에 적합한 속도
        //4.SENSOR_DELAY_NORMAL     200,000ms 화면 방향 변화를 모니터링하기에 적합한

    }

    @Override
    protected void onResume(){
        super.onResume( );
        sensorManager.registerListener( this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause( );
        sensorManager.unregisterListener( this );
    }

    @Override
    public void onAccuracyChanged( Sensor sensor, int accuracy )  {
    }

    @Override
    public void onSensorChanged( SensorEvent event ) {

        float dbDistance = event.values[0];
        // 스마트폰 위에 손을 올리면 아래와 같이 출력되고
        // distance(0.0)
        // 손을 치우면 아래와 같이 출력된다.
        // distance(8.0)
        if (dbDistance == 0.0){
            int soundId = sound.load(this, R.raw.m2, 1);
            int streamId = sound.play(soundId, 1.0F, 1.0F,  1,  -1,  1.0F);
            Toast.makeText(this, "distance(" + dbDistance + ") 소리나와라" , Toast.LENGTH_SHORT).show();
        }

        Log.d( "Sensor", "distance(" + dbDistance + ")" );
    }



    public void callSound(View v){
        int soundId = sound.load(this, R.raw.m2, 1);
        streamId = sound.play(soundId, 0.5F, 0.5F,  1,  0,  1.0F);
    }

}
