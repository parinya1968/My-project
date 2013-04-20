package rru.RawAudioPlayer;
import java.io.IOException;
import android.app.Activity;
import android.media.MediaPlayer; // package ที่ใช้สำหรับการเล่นเสียง
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RawAudioPlayer extends Activity implements View.OnClickListener {
	static MediaPlayer mp = null; // ประกาศตัวแปรชนิด MediaPlayer
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);       
        Button btnPlay = (Button) this.findViewById(R.id.Button01); 
        Button btnStop = (Button) this.findViewById(R.id.Button02);      
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);  
    }
	public void onClick(View v) {
		if (v.equals(this.findViewById(R.id.Button01))){
			 mp = MediaPlayer.create(RawAudioPlayer.this, R.raw.tormaitor); // โหลดไฟล์เพลงที่เก็บอยู่ใน /res/raw  (หากไม่มีไดเรคทอรี่ raw ให้สร้างขึ้นมาใหม่)
			 mp.start();   // เริ่มเล่นเสียง
		}else{
			mp.stop(); // หยุดเสียง
			mp.release(); // คืนหน่วยความจำที่ใช้ให้ระบบ
			try {
				mp.prepare(); // เตรียมตัวเล่นเพื่อรอเล่นครั้งต่อไป
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
