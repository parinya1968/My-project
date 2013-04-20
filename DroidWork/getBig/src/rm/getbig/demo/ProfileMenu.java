package rm.getbig.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProfileMenu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilemenu);
        
        //Buttons Listener View Routine
        Button btnViewR = (Button)findViewById(R.id.groups_profile_viewR);
        //Button Listener View Profile
        Button btnViewP = (Button)findViewById(R.id.groups_profile_viewP);
        //Button Listener Add profile
        Button btnAddP = (Button)findViewById(R.id.groups_profile_create);
        
      //Intent of btnViewR
        final Intent iViewR = new Intent(getApplicationContext(),ViewR.class);
      //Intent of btnViewP
        final Intent iViewP = new Intent(getApplicationContext(),ViewProfiles.class);
      //Intent of btnAddP
        final Intent iAddP = new Intent(getApplicationContext(),AddNewprofile.class);
        
      //Go to View Routine Activity
        btnViewR.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(iViewR);
			}
        	
        });
        
      //Go to View Profile Activity
        btnViewP.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(iViewP);
			}
        	
        });
        
      //Go to Add Profile Activity
        btnAddP.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(iAddP);
			}
        	
        });
    }
}