package droid.media.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

public class AudioPlayer extends Activity {
	//Define Path && Define Button
	static final String MUSIC_DIR="/music";
	Button playPauseButton;
	private MediaPlayer m_mediaPlayer;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audioplayer);
        //Button Listener declaration
        playPauseButton = (Button)findViewById(R.id.play_pause);
        
        //Create instance from MediaPlayer Class
        m_mediaPlayer = new MediaPlayer();
        
        //Fetch Music Directory
        String MusicDir = Environment.getExternalStorageDirectory().getAbsolutePath() + MUSIC_DIR;
        
        //File List here
        Intent i = new Intent(this,ListFiles.class);
        i.putExtra("directory", MusicDir);
        startActivityForResult(i,0);
        
        //button Listener Action
        playPauseButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View view){
        		//When Click Button Check if Resume play
        		if(m_mediaPlayer.isPlaying()){
        			pauseMP();
        		}else{
        			startMP();
        		}
        		
        	}
        });
    }  


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 0 && resultCode == RESULT_OK){
			String tmp = data.getExtras().getString("clickedFile");
			
			//Protect Error in case of system can't find media
			try{
				m_mediaPlayer.setDataSource(tmp);
				m_mediaPlayer.prepare();
			} catch (Exception e){
				e.printStackTrace();
			}
			//Start player
			startMP();
		}
		
	}
	
	//Pause Method
	void pauseMP(){
		playPauseButton.setText("Play");
		m_mediaPlayer.pause();
	}
	
	//Start Method
	void startMP(){
		m_mediaPlayer.start();
		playPauseButton.setText("Pause");
	}
	
	//Resume checker
	boolean needToResume = false;
	@Override
	protected void onPause(){
		if(m_mediaPlayer != null && m_mediaPlayer.isPlaying()){
			needToResume = true;
			pauseMP();
		}
		super.onPause();
	}
	@Override
	protected void onResume(){
		super.onResume();
		if(needToResume && m_mediaPlayer != null){
			startMP();
		}
	}
}
