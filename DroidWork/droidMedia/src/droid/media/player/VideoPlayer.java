package droid.media.player;


import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoplayer);
        VideoView view = (VideoView) findViewById(R.id.VideoView01);
	    
 	   view.setVideoPath("/sdcard/tonyja.3gp");
 	   view.setMediaController(new MediaController(this));
 	   view.requestFocus();
    }
}