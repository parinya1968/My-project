package com.pass.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
 
	public class ActivityTwo extends Activity {
 
		TextView textView;
 
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			/** setting the view of the activity to xml */
			setContentView(R.layout.activity2);
			textView = (TextView) findViewById(R.id.txt2);
			 
			/**get the intent*/
			Intent intent = getIntent();
			 
			/**retrieve the string extra passed*/
			String stringRecd = intent.getStringExtra("name");
			 
			/*retrieve the boolean extra passed*/
			Boolean boolRecd = intent.getBooleanExtra("testBool", false);
			textView.setText(stringRecd + ":boolval:"+boolRecd );
		}
			 
}
