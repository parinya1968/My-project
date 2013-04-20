package com.droid.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DroidClientActivity extends Activity {
	private final String DEBUG_TAG = "DroidClient";
	private TextView mTextView = null;
	private EditText mEditText = null;
	private Button mButton = null;
	private Socket socket = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*Event on Button, Text etc.*/
        mButton = (Button)findViewById(R.id.button1);
        mTextView = (TextView)findViewById(R.id.textView1);
        mEditText = (EditText)findViewById(R.id.editText1);
        mButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String message = mEditText.getText().toString() + "\r\n";
        		try{
        			//Home IP Address
        			//socket = new Socket("192.168.1.3", 4446);
        			//-----------------------------
        			//University IP Address
        			socket = new Socket("192.168.36.27", 4446);
        			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        			out.println(message);
        			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        			String msg = br.readLine();
        			if(msg != null){
        				mTextView.setText(mTextView.getText() + "\n" +msg);
        			} else {
        				mTextView.setText(" Data Error !");
        			}
        			out.close();
        			br.close();
        			socket.close();
        		} catch (Exception e){
        			Log.e(DEBUG_TAG,e.toString());
        		}
        	}
        });
        
    }
}