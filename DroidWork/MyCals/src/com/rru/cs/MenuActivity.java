package com.rru.cs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {
    /** Called when the activity is first created. */
	Button btn1,btn2;
	Intent i = new Intent(), i2 = new Intent();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        i.setClass(this, AboutActivity.class);
        i2.setClass(this, MyCalsActivity.class);
        //Button1 Event
        
        btn1.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0){
        		startActivity(i);
        	}
        
        
        });
        
        /*Button2 Event*/
        btn2.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0){
        		startActivity(i2);
        	}
        
        
        });
    }
}