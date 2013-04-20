package app.masterUNG.Test_MyStudent_SQLite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void ClickAddNewStudent(View view) {
		
    	Intent goAddNewStaudent = new Intent(getApplicationContext(), AddNewStudent.class);
    	startActivity(goAddNewStaudent);
    	
	}
    public void ClickViewAllStudent(View view) {
		
    	Intent goShowListStudent = new Intent(getApplicationContext(), ViewAllStudent.class);
    	startActivity(goShowListStudent);
    	
    	
	}
}