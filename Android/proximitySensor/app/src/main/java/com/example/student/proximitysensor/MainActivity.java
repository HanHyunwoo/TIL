package com.example.student.proximitysensor;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager m_clsSensorManager;
    private Sensor m_clsSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //getSystemService : 센서 매니저 객체를 시스템 서비스로 참조하겠다.
        m_clsSensorManager = (SensorManager)getSystemService( Context.SENSOR_SERVICE );
        m_clsSensor = m_clsSensorManager.getDefaultSensor( Sensor.TYPE_PROXIMITY );
    }

    @Override
    protected void onResume(){
        super.onResume( );
        m_clsSensorManager.registerListener( this, m_clsSensor, SensorManager.SENSOR_DELAY_NORMAL );
    }

    @Override
    protected void onPause() {
        super.onPause( );
        m_clsSensorManager.unregisterListener( this );
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
        Toast.makeText(this, "distance(" + dbDistance + ")" , Toast.LENGTH_SHORT).show();
        Log.d( "Sensor", "distance(" + dbDistance + ")" );
    }
}