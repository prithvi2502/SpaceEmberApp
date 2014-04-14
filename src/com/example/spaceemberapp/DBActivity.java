package com.example.spaceemberapp;

import java.util.HashMap;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class DBActivity extends Activity implements SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private Sensor mGyro;
	private long lastUpdate = 0;
	private float lastx;
	private float lasty; 
	private float lastz;
	private static final int SHAKETHRESHOLD = 3000;
	private static final float ROTATIONALTRESHHOLD = 2000;
	private TextView textview1;
	private TextView textview2x, textview2y, textview2z;
	private TextView textview3x, textview3y, textview3z;
	private TextView textview4;
	public static final int S1 = R.raw.s1;
	public static final int S2 = R.raw.s2;
	private static SoundPool soundPool;
	int fornum;
	int secondnum;
	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_db);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	    mGyro = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
	    mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager.registerListener(this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
	    textview1 = (TextView) findViewById(R.id.textView1);
	    textview2x = (TextView) findViewById(R.id.textView2x);
	    textview2y = (TextView) findViewById(R.id.textView2y);
	    textview2z = (TextView) findViewById(R.id.textView2z);
	    textview3x = (TextView) findViewById(R.id.textview3x);
	    textview3y = (TextView) findViewById(R.id.textview3y);
	    textview3z = (TextView) findViewById(R.id.textview3z);
	    textview4 = (TextView) findViewById(R.id.textview4);
	    
	    
	    //Sound Generation
	    soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
	    fornum = soundPool.load(this, R.raw.s1, 1);
	    secondnum = soundPool.load(this, R.raw.s2, 1);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent Event) {
		// TODO Auto-generated method stub
		Sensor mSensor = Event.sensor;
		 
	    if (mSensor.getType() == Sensor.TYPE_ACCELEROMETER) {
	    	float x = Event.values[0];
	        float y = Event.values[1];
	        float z = Event.values[2];
	        textview2x.setText("X = " + x + "m/s^2");
	        textview2y.setText("Y = " + y + "m/s^2");
	        textview2z.setText("Z = " + z + "m/s^2"); 
	        long curTime = System.currentTimeMillis();
	        if ((curTime - lastUpdate) > 100) {
	            long diffTime = (curTime - lastUpdate);
	            lastUpdate = curTime;
	            
	            float speed = Math.abs(x + y + z - lastx - lasty - lastz)/ diffTime * 10000;
	            
	            if (speed > SHAKETHRESHOLD) {
	            	textview1.setText("You are moving to eratically! Slow Down");
	            	soundPool.play(fornum, 1, 1, 0,0, 1);
	            }else{
	            	textview1.setText("Your movement is ok now");
	            	soundPool.stop(fornum);
	            }
	 
	            lastx = x;
	            lasty = y;
	            lastz = z;
	        }
	    }else if (mSensor.getType() == Sensor.TYPE_GYROSCOPE) {
	    	float x = Event.values[0];
	        float y = Event.values[1];
	        float z = Event.values[2];
	        textview3x.setText("X = " + x + "m/s^2");
	        textview3y.setText("Y = " + y + "m/s^2");
	        textview3z.setText("Z = " + z + "m/s^2");
	        long curTime = System.currentTimeMillis();
	        if ((curTime - lastUpdate) > 100) {
	            long diffTime = (curTime - lastUpdate);
	            lastUpdate = curTime;
	            
	            float speed = Math.abs(x + y + z - lastx - lasty - lastz)/ diffTime * 10000;
	            
	            if (speed > ROTATIONALTRESHHOLD) {
	            	textview4.setText("You are rotating to eratically! Slow Down");
	            	soundPool.play(secondnum, 1, 1, 0,0, 1);
	            	
	            }else{
	            	textview4.setText("Your rotational movement is ok now");
	            	soundPool.stop(secondnum);
	            }
	 
	            lastx = x;
	            lasty = y;
	            lastz = z;
	        }
        }
	}
	protected void onPause() {
	    super.onPause();
	    mSensorManager.unregisterListener(this);
	}
	protected void onResume() {
	    super.onResume();
	    mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}
}