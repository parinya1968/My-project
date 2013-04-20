package pass.data.acts;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Act2 extends Activity {
    /** Called when the activity is first created. */
	String act2String = "defg";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2);
        
        //Text View Listener
        TextView txtResult = (TextView)findViewById(R.id.txtGet);
        //Get value
        String resultString=getIntent().getStringExtra("ResultInString");
        
        //Show Value
        txtResult.setText("We Have Message from Activity 1 = " +resultString);        
        
        /*---------------------------------------------------------------------*/
        /*Send Back Procedure*/
        //Combine Message
        act2String = resultString + act2String;
        //Button Listener
        Button btnBack = (Button) findViewById(R.id.sndBack);
        //Intent of Act2
        final Intent intent=new Intent(getApplicationContext(),Act1.class);
        intent.putExtra("ResultFromAct2",act2String);
        
      //on click sndBack
        btnBack.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(intent);
			}
        	
        });
    }
}