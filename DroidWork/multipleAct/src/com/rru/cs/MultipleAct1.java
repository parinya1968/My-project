package com.rru.cs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MultipleAct1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Button Event
        //btnScr1
        Button btnScreen1 = (Button) findViewById(R.id.btnScr1);
        //navigate to activity2
        final Intent i =new Intent(this,MultipleAct2.class);
        
        
        btnScreen1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(i);
			}
        	
        });
    }
}