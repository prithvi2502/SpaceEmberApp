package com.example.spaceemberapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ClothesActivity extends Activity {
	ArrayList<String> ListSpaceSuit = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clothes);
		ListView equipmentList = (ListView)findViewById(R.id.listView1);
		populateList();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ListSpaceSuit);
		equipmentList.setAdapter(adapter);
	}

	private void populateList() {
		// TODO Auto-generated method stub
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
		String testVar = null;
		
			testVar = "Tether";
			String restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Tether");
			}
	
			testVar = "Cuffs Checklist";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Cuffs Checklist");
			}
			testVar = "Wrist Mirrors";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Wrist Mirrors");
			}
			testVar = "SAFER";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("SAFER");
			}
			testVar = "MAG";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("MAG");
			}
			testVar = "LCVG";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("LCVG");
			}
			testVar = "CCA";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("CCA");
			}
			testVar = "Helmet";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Helmet");
			}
			testVar = "Lower Torso Essembly";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Lower Torso Assembly");
			}
			testVar = "IDB";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("IDB");
			}
			testVar = "DCM";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("DCM");
			}
			testVar = "Gloves";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Gloves");
			}
			testVar = "Upper Torso";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Upper Torso");
			}
			testVar = "PLSS";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("PLSS");
			}
			testVar = "Arm";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("Arm");
			}
			testVar = "HUT";
			restoredText = prefs.getString(testVar, "");
			if(restoredText.equals("true")){
				ListSpaceSuit.add("HUT");
			}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}