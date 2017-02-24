package com.kelompok16.supercow;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class Home extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mProximity;
    private Sapi sapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sapi = new Sapi();

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if(event.values[0]>=-0.01 && event.values[0]<=0.01) {
                Toast.makeText(getApplicationContext(), "say MOOOOO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "go near and you will be surprised" , Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,mProximity,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void goCowSleep() {
        sapi.setWake(false);
    }

    public void goCowWake() {
        sapi.setWake(true);
    }

    public void sleepButton() {
        if(sapi.getEnergy() < 100){
            goCowSleep();
            Toast.makeText(getApplicationContext(),"cow is died",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"cow is very ZEALED",Toast.LENGTH_SHORT).show();
    }
}
