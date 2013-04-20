package telephone.sqlite.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup;


public class AddName extends Activity implements OnClickListener {
    
	/** Called when the activity is first created. */
	protected static  String imgSelect;
	private EditText textName;
	private EditText textNumber;
	private DataBateSQListe dh;
	public final Item[] items = {new Item("à¸œà¸¹à¹‰à¸Šà¸²à¸¢",R.drawable.man_),
			  new Item("à¸œà¸¹à¹‰à¸«à¸�à¸´à¸‡",R.drawable.women_),
			  new Item("à¹€à¸žà¸·à¹ˆà¸­à¸™à¸œà¸¹à¹‰à¸Šà¸²à¸¢",R.drawable.boyfriends_),
			  new Item("à¹€à¸žà¸·à¹ˆà¸­à¸™à¸œà¸¹à¹‰à¸«à¸�à¸´à¸‡",R.drawable.girlfriends_),
			  new Item("à¸™à¹‰à¸­à¸‡à¸Šà¸²à¸¢",R.drawable.brother_),
			  new Item("à¸™à¹‰à¸­à¸‡à¸ªà¸²à¸§",R.drawable.sister_),
			  new Item("à¹�à¸Ÿà¸™à¸«à¸™à¸¸à¹ˆà¸¡",R.drawable.boyfriend_),
			  new Item("à¹�à¸Ÿà¸™à¸ªà¸²à¸§",R.drawable.girlfriend_),
			  new Item("à¹„à¸¡à¹ˆà¹€à¸¥à¸´à¸­à¸�",R.drawable.noimg_)};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addname);
        
        Button bt4 = (Button)findViewById(R.id.btAdd);
        bt4.setOnClickListener(this);
        Button bt5 = (Button)findViewById(R.id.btCancel);
        bt5.setOnClickListener(this);
        Button bt6 = (Button)findViewById(R.id.btImage);
        bt6.setOnClickListener(this);
        
        this.textName = (EditText)findViewById(R.id.textName);
        this.textNumber = (EditText)findViewById(R.id.textNumber);
        
        imgSelect = "noimg";
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String name = String.valueOf(this.textName.getText());
		String number = String.valueOf(this.textNumber.getText());
		this.dh = new DataBateSQListe(this);
		
		if(v.getId()==R.id.btAdd){
			if(name.length()>0 && number.length()==10 && this.isInt(number)&&
					this.dh.countColumns("name",name)==0){
				
		        this.dh.insert(name,number,imgSelect);
				
				this.textName.setText("");
				this.textNumber.setText("");
				Toast.makeText(getApplicationContext(), "à¹€à¸£à¸µà¸¢à¸šà¸£à¹‰à¸­à¸¢", Toast.LENGTH_SHORT).show();
				finish();
			}
			else if(name.length()==0){
				Intent i = new Intent(getApplicationContext(),ShowMsg.class);
		        i.putExtra("strError", "à¸�à¸£à¸¸à¸“à¸²à¹ƒà¸ªà¹ˆà¸Šà¸·à¹ˆà¸­");				
				startActivity(i);
			}
			else if( number.length()!=10 || !this.isInt(number)){
				Intent i = new Intent(getApplicationContext(),ShowMsg.class);
		        i.putExtra("strError", "à¹ƒà¸ªà¹ˆà¸«à¸¡à¸²à¸¢à¹€à¸¥à¸‚à¹‚à¸—à¸£à¸¨à¸±à¸žà¸—à¹Œ 10 à¸«à¸¥à¸±à¸�  à¹€à¸›à¹‡à¸™à¸•à¸±à¸§à¹€à¸¥à¸‚");				
				startActivity(i);
			}
			else if(this.dh.countColumns("name",name)!=0){
				Intent i = new Intent(getApplicationContext(),ShowMsg.class);
		        i.putExtra("strError", "à¹„à¸¡à¹ˆà¸ªà¸²à¸¡à¸²à¸£à¸–à¹ƒà¸Šà¹‰à¸Šà¸·à¹ˆà¸­à¸™à¸µà¹‰à¹„à¸”à¹‰");				
				startActivity(i);
			}
		}
		else if(v.getId()==R.id.btImage){
			chooseWanted();
		}
		else{
			finish();
		}
	}
	
	protected void chooseWanted() {
		// TODO Auto-generated method stub
		
		ListAdapter adapter = new ArrayAdapter<Item>(this,
			    android.R.layout.select_dialog_item,
			    android.R.id.text1,
			    items){
			        public View getView(int position, View convertView, ViewGroup parent) {
			            //User super class to create the View
			            View v = super.getView(position, convertView, parent);
			            TextView tv = (TextView)v.findViewById(android.R.id.text1);

			            //Put the image on the TextView
			            tv.setCompoundDrawablesWithIntrinsicBounds(items[position].icon, 0, 0, 0);

			            //Add margin between image and text (support various screen densities)
			            int dp5 = (int) (5 * getResources().getDisplayMetrics().density + 0.5f);
			            tv.setCompoundDrawablePadding(dp5);

			            return v;
			        }
			    };

			new AlertDialog.Builder(this)
			    .setTitle("à¹€à¸¥à¸·à¸­à¸�à¸£à¸¹à¸›à¸ à¸²à¸ž")
			    .setAdapter(adapter, new DialogInterface.OnClickListener() {
			    	
			        public void onClick(DialogInterface dialog, int item) {
			        	
			        	ImageView img = (ImageView)findViewById(R.id.imageView);
						
						if (items[item].toString() == "à¸œà¸¹à¹‰à¸Šà¸²à¸¢")	{
							img.setImageResource(R.drawable.man);
							imgSelect = "man";
						}
						else if (items[item].toString() == "à¸œà¸¹à¹‰à¸«à¸�à¸´à¸‡")	{
							img.setImageResource(R.drawable.women);
							imgSelect = "women";
						}
						else if (items[item].toString() == "à¹€à¸žà¸·à¹ˆà¸­à¸™à¸œà¸¹à¹‰à¸Šà¸²à¸¢")	{
							img.setImageResource(R.drawable.boyfriends);
							imgSelect = "boyfriends";
						}
						else if (items[item].toString() == "à¹€à¸žà¸·à¹ˆà¸­à¸™à¸œà¸¹à¹‰à¸«à¸�à¸´à¸‡")	{
							img.setImageResource(R.drawable.girlfriends);
							imgSelect = "girlfriends";
						}
						else if (items[item].toString()== "à¸™à¹‰à¸­à¸‡à¸Šà¸²à¸¢")	{
							img.setImageResource(R.drawable.brother);
							imgSelect = "brother";
						}
						else if (items[item].toString()== "à¸™à¹‰à¸­à¸‡à¸ªà¸²à¸§")	{
							img.setImageResource(R.drawable.sister);
							imgSelect = "sister";
						}
						else if (items[item].toString()== "à¹�à¸Ÿà¸™à¸«à¸™à¸¸à¹ˆà¸¡")	{
							img.setImageResource(R.drawable.boyfriend);
							imgSelect = "boyfriend";
						}
						else if (items[item].toString() == "à¹�à¸Ÿà¸™à¸ªà¸²à¸§")	{
							img.setImageResource(R.drawable.girlfriend);
							imgSelect = "girlfriend";
						}
						else if(items[item].toString() == "à¹„à¸¡à¹ˆà¹€à¸¥à¸·à¸­à¸�"){
							img.setImageResource(R.drawable.noimg);
							imgSelect = "girlfriend";
						}
			        }
			    }).show();
	}
	
	public boolean isInt(String i){
		try{
			Integer.parseInt(i);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public static class Item{
	    public final String text;
	    public final int icon;
	    
	    public Item(String text, Integer icon) {
	        this.text = text;
	        this.icon = icon;
	    }
	    @Override
	    public String toString() {
	        return text;
	    }
	}
}
