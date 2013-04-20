package com.pass.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TextInput extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
        
        public void goToNextActivity(View v) {
            String theText = null;
            //first get the EditText View and extract the text...
            EditText theInput = (EditText)findViewById(R.id.the_input);
            if(theInput != null) {
                theText = theInput.getText().toString();
            }
            //create a new Intent
            Intent i = new Intent(this, TextView.class);
            //add theText to the intent
            i.putExtra(TextView.TEXT_DATA, theText);
            //start the activity
            startActivity(i);
    }
}