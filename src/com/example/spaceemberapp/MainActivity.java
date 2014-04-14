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

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("SpaceWalkState", "false");
		editor.commit();
		
		Button btnLaunch = (Button) findViewById(R.id.button1);
		btnLaunch.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(), StatusActivity.class);
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
