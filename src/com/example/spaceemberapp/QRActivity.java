package com.example.spaceemberapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class QRActivity extends Activity implements OnClickListener {
	private Button scanBtn;
	private TextView formatType, contentType, responseType, result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qr);
		scanBtn = (Button)findViewById(R.id.scan_button);
		formatType = (TextView)findViewById(R.id.scan_format);
		contentType = (TextView)findViewById(R.id.scan_content);
		responseType = (TextView)findViewById(R.id.response);
		result = (TextView)findViewById(R.id.result);
		scanBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.scan_button){
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan();
		}
		
	}
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanningResult != null) {
			String scanContent = scanningResult.getContents();
			String scanFormat = scanningResult.getFormatName();
			formatType.setText("FORMAT: " + scanFormat);
			contentType.setText("CONTENT: " + scanContent);
			processCode(scanContent);
			responseType.setText("Data logged");	
			result.setText(retrieveOBJ(scanContent));
				
		}else{
	    Toast toast = Toast.makeText(getApplicationContext(), 
	            "No scan data received!", Toast.LENGTH_SHORT);
	        toast.show();
	    }
	}
	private String retrieveOBJ(String b) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); 
		String testVar = null;
		if(b.equals("4s5e834")){
			testVar = "Tether";
		}else if(b.equals("38d52f5")){
			testVar = "Cuffs Checklist";
		}else if(b.equals("232d53e")){
			testVar = "Wrist Mirrors";
		}else if(b.equals("25d25e6")){
			testVar = "SAFER";
		}else if(b.equals("55e84f4")){
			testVar = "MAG";
		}else if(b.equals("235e145")){
			testVar = "LCVG";
		}else if(b.equals("24e11s6")){
			testVar = "CCA";
		}else if(b.equals("548e1s4")){
			testVar = "Helmet";
		}else if(b.equals("654e62s")){
			testVar = "Lower Torso Assembly";
		}else if(b.equals("25e62s6")){
			testVar = "IDB";
		}else if(b.equals("7886s8e")){
			testVar = "DCM";
		}else if(b.equals("336s85e")){
			testVar = "Gloves";
		}else if(b.equals("3s44e4f")){
			testVar = "Upper Torso";
		}else if(b.equals("53484s6")){
			testVar = "PLSS";
		}else if(b.equals("4832se8")){
			testVar = "Arm";
		}else if(b.equals("48863se")){
			testVar = "HUT";
		}
		String restoredText = prefs.getString(testVar, "");
		if(restoredText.equals("true")){
			return "You are wearing " + testVar + " and this has been added to your log";
		}
		return restoredText;
	}

	public void processCode(String b) {
		  String testVar = null;
		  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		  SharedPreferences.Editor editor = preferences.edit();
		  if(b.equalsIgnoreCase("4s5e834")){
			  testVar = "Tether";
			}else if(b.equals("38d52f5")){
				testVar = "Cuffs Checklist";
			}else if(b.equals("232d53e")){
				testVar = "Wrist Mirrors";
			}else if(b.equals("25d25e6")){
				testVar = "SAFER";
			}else if(b.equals("55e84f4")){
				testVar = "MAG";
			}else if(b.equals("235e145")){
				testVar = "LCVG";
			}else if(b.equals("24e11s6")){
				testVar = "CCA";
			}else if(b.equals("548e1s4")){
				testVar = "Helmet";
			}else if(b.equals("654e62s")){
				testVar = "Lower Torso Assembly";
			}else if(b.equals("25e62s6")){
				testVar = "IDB";
			}else if(b.equals("7886s8e")){
				testVar = "DCM";
			}else if(b.equals("336s85e")){
				testVar = "Gloves";
			}else if(b.equals("3s44e4f")){
				testVar = "Upper Torso";
			}else if(b.equals("53484s6")){
				testVar = "PLSS";
			}else if(b.equals("4832se8")){
				testVar = "Arm";
			}else if(b.equals("48863se")){
				testVar = "HUT";
			}
		  
		editor.putString(testVar, "true");
		  editor.commit();
	}
}