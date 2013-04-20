package telephone.sqlite.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class ShowMsg extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	public String msg;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmsg);
        
        String err = getIntent().getStringExtra("strError");
        
        TextView text = (TextView)findViewById(R.id.textMsg);
        text.setText(err);
        
        Button bt1 = (Button)findViewById(R.id.btOkErr);
        bt1.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		finish();
	}

}