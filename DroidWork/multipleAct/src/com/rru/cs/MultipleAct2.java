package com.rru.cs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MultipleAct2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scr2);
        
        //Button Event
        //btnScr2
        Button btnScreen2 = (Button) findViewById(R.id.btnScr2);
        final Intent i =new Intent(this,MultipleAct1.class);
        
        btnScreen2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(i);
			}
        	
        });
    }
}