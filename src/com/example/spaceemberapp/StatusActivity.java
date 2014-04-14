package com.example.spaceemberapp;




import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


public class StatusActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);
		ImageButton imgButtonQR = (ImageButton) findViewById(R.id.ImageButton01);
		imgButtonQR.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(), QRActivity.class);
				startActivityForResult(intent, 0);
			}
		});
		ImageButton imgButtonDB = (ImageButton) findViewById(R.id.ImageButton02);
		imgButtonDB.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(), DBActivity.class);
				startActivityForResult(intent, 0);
			}
		});
		ImageButton imgButtonCl = (ImageButton) findViewById(R.id.imageButton2);
		imgButtonCl.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(), ClothesActivity.class);
				startActivityForResult(intent, 0);
			}
		});
		
		final Button buttonCheck = (Button) findViewById(R.id.button_check);
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
		String restoredText = prefs.getString("SpaceWalkState", "");
		if(restoredText.equals("true")){
			buttonCheck.setText("Enter Ship");
			
		}else if(restoredText.equals("false")){
			buttonCheck.setText("Go for a SpaceWalk");
		}
		buttonCheck.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(buttonCheck.getText().toString().equals("Go for a SpaceWalk")){
					buttonCheck.setText("Enter Ship");
					SharedPreferences.Editor editor = prefs.edit();
					editor.putString("SpaceWalkState", "true");
					editor.commit();
					Intent intent = new Intent(v.getContext(), checkActivity.class);
					startActivityForResult(intent, 0);
				}else{
					buttonCheck.setText("Go for a SpaceWalk");
					SharedPreferences.Editor editor = prefs.edit();
					editor.putString("SpaceWalkState", "false");
					editor.commit();
				}
				
			}
		});
		ImageButton imgButtonPF = (ImageButton) findViewById(R.id.imageButton1);
		imgButtonPF.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(), ProfileActivity.class);
				startActivityForResult(intent, 0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
