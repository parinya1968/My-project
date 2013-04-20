package rm.getbig.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HowTo extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howto);
        
        //Buttons Listener
        Button howtoBackBtn = (Button)findViewById(R.id.howtoBackBtn);
        
        final Intent ihowtoBackBtn = new Intent(getApplicationContext(),MainScr.class);
        
      //Onclick & Go
        howtoBackBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(ihowtoBackBtn);
			}
        	
        });
        
    }
}