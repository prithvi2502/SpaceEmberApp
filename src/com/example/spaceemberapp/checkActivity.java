package com.example.spaceemberapp;
import java.util.Locale;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class checkActivity extends Activity {
	TextToSpeech ttobj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check);
		TextView finalcheck = (TextView) findViewById(R.id.textView14);
		finalcheck.setText(checkMet());
		ttobj=new TextToSpeech(getApplicationContext(), 
			    new TextToSpeech.OnInitListener() {
			    @Override
			    public void onInit(int status) {
			       if(status != TextToSpeech.ERROR){
			           ttobj.setLanguage(Locale.UK);
			          }				
			       }
			    });
		
		
		if(finalcheck.getText().toString().equals("You Are Good To Go")){
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString("SpaceWalkState", "true");
			editor.commit();
			ttobj.speak("You Are Good To Go", TextToSpeech.QUEUE_FLUSH, null);
		}else{
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString("SpaceWalkState", "false");
			editor.commit();
			ttobj.speak("You are not ready to go yet. You have forgotten some things", TextToSpeech.QUEUE_FLUSH, null);
		}
	}

	private String checkMet() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
		String testVar = null;
		String resultReturn = "Wow! You forgot: ";
		testVar = "Tether";
		String restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Tether ";
		}

		testVar = "Cuffs Checklist";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Cuffs Checklist ";
		}
		testVar = "Wrist Mirrors";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Wrist Mirrors ";
		}
		testVar = "SAFER";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " SAFER ";
		}
		testVar = "MAG";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " MAG ";
		}
		testVar = "LCVG";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
		
		}else{
			 resultReturn = resultReturn + " LCVG ";
		}
		testVar = "CCA";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " CCA ";
		}
		testVar = "Helmet";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Helmet ";
		}
		testVar = "Lower Torso Assembly";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Lower Torso Assembly ";
		}
		testVar = "IDB";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " IDB ";
		}
		testVar = "DCM";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " DCM ";
		}
		testVar = "Gloves";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Gloves ";
		}
		testVar = "Upper Torso";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Upper Torso ";
		}
		testVar = "PLSS";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " PLSS ";
		}
		testVar = "Arm";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " Arm ";
		}
		testVar = "HUT";
		restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			
		}else{
			 resultReturn = resultReturn + " HUT ";
		}
		
		
		if(resultReturn.equals("Wow! You forgot: ")){
			return "You Are Good To Go";
			
		}else{
			return resultReturn;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}