package com.rru.cs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyCalsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Linking GUIs */
       /*----------------------------*/ 
        /* Button Group*/
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        /* Plain Text Group*/
        final EditText edt1 = (EditText)findViewById(R.id.editText1);
        final EditText edt2 = (EditText)findViewById(R.id.editText2);
        /* Text View using only TextView2*/
        final TextView txtv = (TextView)findViewById(R.id.textView1);
        /*-------------------------------*/
        
        /* Events */
        /* Plus */
        btn1.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                float input1 = Float.parseFloat(edt1.getText().toString());
                float input2 = Float.parseFloat(edt2.getText().toString());
                double output1 = input1 + input2;
                txtv.setText(output1+ " ");
            }
            
            
        });
        
        /*Subtraction*/
        btn2.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                float input1 = Float.parseFloat(edt1.getText().toString());
                float input2 = Float.parseFloat(edt2.getText().toString());
                double output1 = input1 - input2;
                txtv.setText(output1+ " ");
            }
            
            
        });
        
        /*Multiplier*/
        btn3.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                float input1 = Float.parseFloat(edt1.getText().toString());
                float input2 = Float.parseFloat(edt2.getText().toString());
                double output1 = input1 * input2;
                txtv.setText(output1+ " ");
            }
            
            
        });
        
        /*Division*/
        btn4.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                float input1 = Float.parseFloat(edt1.getText().toString());
                float input2 = Float.parseFloat(edt2.getText().toString());
                double output1 = input1 / input2;
                txtv.setText(output1+ " ");
            }
            
            
        });
    }
}