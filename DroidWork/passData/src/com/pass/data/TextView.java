package com.pass.data;

import android.app.Activity;
import android.os.Bundle;

public class TextView extends Activity {
	//Define text data use for passing
	public static final String TEXT_DATA = "textData";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.txtview);
        
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String theText = extras.getString(TEXT_DATA);
            if(theText != null) {
                TextView t = (TextView)findViewById(R.id.the_text);
                if(t != null) {
                    t.setText(theText);
                }
            }
        }
    }
}