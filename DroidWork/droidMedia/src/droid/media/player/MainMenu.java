package droid.media.player;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        
      //Buttons Listener
        Button audioBtn = (Button)findViewById(R.id.audioBtn);
        Button videoBtn = (Button)findViewById(R.id.videoBtn);
        
      //Intent of Each
        final Intent iAudio = new Intent(getApplicationContext(),AudioPlayer.class);
        final Intent iVideo = new Intent(getApplicationContext(),VideoPlayer.class);
        //Audio Button on click here
        audioBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 startActivity(iAudio);
			}
        	
        });
        //Video Button On click
        videoBtn.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View arg0){
        		startActivity(iVideo);
        	}
        });
    }
}