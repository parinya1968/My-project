package com.web.webview;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WebViewMain extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
      //Buttons Listener
        Button btnOn = (Button)findViewById(R.id.btnOn);
        Button btnOff = (Button)findViewById(R.id.btnOff);
        
      //Intent of Each
        final Intent iOnline = new Intent(getApplicationContext(),WebViewOnline.class);
        final Intent iOffline = new Intent(getApplicationContext(),WebViewOffline.class);
        
      //Online Button on click here
        btnOn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(iOnline);
			}
        	
        });
        //Offline Button On click
        btnOff.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View arg0){
        		startActivity(iOffline);
        	}
        });
    }
}