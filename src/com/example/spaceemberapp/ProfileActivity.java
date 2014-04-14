package com.example.spaceemberapp;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends Activity {
	TextView spaceStatusTxt;
	TextView pressureTxt;
	TextView temperatureTxt;
	TextView lightTxt;
	TextView humidTxt;
	TextView magnetTxtx, magnetTxty, magnetTxtz;
	private SensorManager sensorMan;
	private Sensor sensorPressure;
	private SensorManager mSensorManager;
	private Sensor mTemp;
	private Sensor mLight;
	private Sensor mHumidity;
	private Sensor mMagnet;
	@SuppressWarnings("deprecation")
	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		spaceStatusTxt = (TextView) findViewById(R.id.statusView);
		pressureTxt = (TextView) findViewById(R.id.pressureView);
		temperatureTxt = (TextView) findViewById(R.id.textView5);
		lightTxt = (TextView) findViewById(R.id.textView7);
		humidTxt = (TextView) findViewById(R.id.textView8);
		magnetTxtx = (TextView) findViewById(R.id.textView9x);
		magnetTxty = (TextView) findViewById(R.id.textView9y);
		magnetTxtz = (TextView) findViewById(R.id.textView9z);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
		String restoredText = prefs.getString("SpaceWalkState", "");
		if(restoredText.equals("true")){
			spaceStatusTxt.setText("Currently Spacewalking");
			
		}else{
			spaceStatusTxt.setText("Currently in Spaceship");
		}
		
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		sensorPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
	    mTemp = mSensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
	    mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
	    mMagnet = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
	    mHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
	    mSensorManager.registerListener(SensorListener, mLight,SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager.registerListener(SensorListener, mTemp,SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager.registerListener(SensorListener, mHumidity,SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager.registerListener(SensorListener, sensorPressure,SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager.registerListener(SensorListener, mMagnet,SensorManager.SENSOR_DELAY_NORMAL);
	}
	private final SensorEventListener SensorListener
    = new SensorEventListener(){

		  @Override
		  public void onAccuracyChanged(Sensor sensor, int accuracy) {
		   // TODO Auto-generated method stub
		   
		  }
		
		  @Override
		  public void onSensorChanged(SensorEvent event) {
			  if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
		    		long timestamp = event.timestamp;
			        float value = event.values[0];
			        String stringValue = String.valueOf(value);
			       
			        	temperatureTxt.setText("AMBIENT TEMPERATURE: " + stringValue + "C");
		    	
				}else if(event.sensor.getType() == Sensor.TYPE_PRESSURE){
					long timestamp = event.timestamp;
			        float value = event.values[0];
			        String stringValue = String.valueOf(value);
			        
			        	pressureTxt.setText("PRESSURE " + stringValue + "hPa");
			        
				}else if( event.sensor.getType() == Sensor.TYPE_LIGHT){
					long timestamp = event.timestamp;
			        float value = event.values[0];
			        String stringValue = String.valueOf(value);
			        
			        	lightTxt.setText("LIGHT " + stringValue + "lx");
			        
				}else if( event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
					long timestamp = event.timestamp;
			        float value = event.values[0];
			        String stringValue = String.valueOf(value);
			      
			        	humidTxt.setText("HUMIDITY " + stringValue + "%");
				}else if( event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
					long timestamp = event.timestamp;
			        float value = event.values[0];
			        String stringValue = String.valueOf(value);
			        magnetTxtx.setText("X = " + event.values[0] + "nT "); 
			        magnetTxty.setText("Y = " + event.values[1] + "nT ");
			        magnetTxtz.setText("Z = " + event.values[2] + "nT ");
				}
		  }
    
     };

	

	

}