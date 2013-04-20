package com.pass.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
 
public class ActivityOne extends Activity {
	EditText editText;
	Button button;
 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	/** setting the view of the activity to xml */
		setContentView(R.layout.main);
 
		editText= (EditText) findViewById(R.id.edit1);
		button= (Button) findViewById(R.id.btn1);
 
		button.setOnClickListener(new OnClickListener() {
		 
		@Override
		public void onClick(View v) {
		// TODO Auto-generated method stub
		 
		/** getting the value of edit text entered by user */
		final String textVal = editText.getText().toString();
		 
		Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
		 
		/** setting the textVal in intentExtra */
		intent.putExtra("name", textVal);
		intent.putExtra("testBool", true);
		 
		startActivity(intent);
			}
		});
 
	}
}
