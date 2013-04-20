package telephone.sqlite.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TelephoneActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Button b1 = (Button)findViewById(R.id.btShow);
        b1.setOnClickListener(this);
        Button b2 = (Button)findViewById(R.id.btNew);
        b2.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId()==R.id.btShow){
			Intent i = new Intent(this,ShowName.class);
			startActivity(i);
		}
		else if(v.getId()==R.id.btNew){
			Intent i = new Intent(this,AddName.class);
			startActivity(i);
		}
		
	}
}