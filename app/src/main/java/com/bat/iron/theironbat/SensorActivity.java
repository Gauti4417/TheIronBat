package com.bat.iron.theironbat;


import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SensorActivity extends Activity implements SensorEventListener {
    RelativeLayout rl;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        rl=(RelativeLayout)findViewById(R.id.R);
        SensorManager sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        int i=Sensor.TYPE_ORIENTATION;
        //int i=Sensor.TYPE_PROXIMITY;
        tv=(TextView)findViewById(R.id.textView5);
        Sensor s=sm.getDefaultSensor(i);
        sm.registerListener(this,s,sm.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] data=event.values;
        /*float object_distance=data[0];
        if(object_distance==0)
        {
            rl.setBackgroundColor(Color.RED);
        }
        else
        {
            rl.setBackgroundColor(Color.CYAN);
        }*/

        float z=data[0];
        float x=data[1];
        float y=data[2];
        String st="ORIENTATION SENSOR";
        st=st+"\nPITCH = "+x;
        st=st+"\nROLL = "+y;
        st=st+"\nAZIMUTH = "+z;

        tv.setText(st);
        rl.setBackgroundColor(Color.rgb((int)x,(int)y,(int)z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
