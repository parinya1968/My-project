package pass.data.acts;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Act1 extends Activity {
    /** Called when the activity is first created. */
	 String resultString="abc";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Buttons Listener
        Button btnEasy = (Button) findViewById(R.id.easyBtn);
        
        //Intent of Each
        final Intent intent=new Intent(getApplicationContext(),Act2.class);
        intent.putExtra("ResultInString",resultString);
        //on click here
        btnEasy.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(intent);
			}
        	
        });
        
        /*-----------------------------------------------------------------*/
        //Receive Message Back Procedure
      //Text View Listener
        TextView txtRecev = (TextView)findViewById(R.id.txtRecev);
        //Get value
        String act2String=getIntent().getStringExtra("ResultFromAct2");
        
        //Show Value
        txtRecev.setText("We Have Message from Activity 2 = " +act2String);  
        
       
    }
}