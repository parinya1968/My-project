package telephone.sqlite.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ShowData extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	public String name;
	public String number;
	public String img;
	private DataBateSQListe dh;
	private int id;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);
        
        this.dh = new DataBateSQListe(this);
        name = getIntent().getStringExtra("name");
        
        number = this.dh.showData(name,2);
        img = this.dh.showData(name,3);
        id = Integer.parseInt(this.dh.showData(name,0));
           
        
        TextView text = (TextView)findViewById(R.id.ShowDataName);
        text.setText(name);
        TextView text2 = (TextView)findViewById(R.id.ShowDataNumber);
        text2.setText(number);
        this.setShowDataImage(img);
        
        Button bt1 = (Button)findViewById(R.id.btOkShowData);
        bt1.setOnClickListener(this);
        Button bt2 = (Button)findViewById(R.id.btDel);
        bt2.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.btOkShowData)
			finish();
		else if(v.getId()==R.id.btDel){
			this.dh.delete_byID(id);
			Intent i = new Intent(getApplicationContext(),ShowName.class);				
		    startActivity(i);
		}
	}
	
	public void setShowDataImage(String img){
		ImageView imgShow = (ImageView)findViewById(R.id.ShowDataImg);
		
		if (img.compareTo("man")==0)
			imgShow.setImageResource(R.drawable.man);
		else if (img.compareTo("women")==0)
			imgShow.setImageResource(R.drawable.women);
		else if (img.compareTo("boyfriends")==0)
			imgShow.setImageResource(R.drawable.boyfriends);
		else if (img.compareTo("girlfriends")==0)
			imgShow.setImageResource(R.drawable.girlfriends);
		else if (img.compareTo("brother")==0)
			imgShow.setImageResource(R.drawable.brother);
		else if (img.compareTo("sister")==0)
			imgShow.setImageResource(R.drawable.sister);
		else if (img.compareTo("boyfriend")==0)
			imgShow.setImageResource(R.drawable.boyfriend);
		else if (img.compareTo("girlfriend")==0)
			imgShow.setImageResource(R.drawable.girlfriend);
		else if(img.compareTo("noimg")==0)
			imgShow.setImageResource(R.drawable.noimg);
		
		imgShow.setVisibility(View.VISIBLE);
		
	}

}