package telephone.sqlite.android;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ShowName extends ListActivity   {
	private DataBateSQListe dh;
	private ItemNode item;
	
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		this.dh = new DataBateSQListe(this);        
		this.item = this.dh.selectAll();
        
		setListAdapter(new MyPerformanceArrayAdapter(this, this.item.name,this.item.img));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		
		Intent i = new Intent(getApplicationContext(),ShowData.class);
		i.putExtra("name",item);				
	    startActivity(i);
	}
	
	public class MyPerformanceArrayAdapter extends ArrayAdapter<String> {
		private final Activity context;
		private final List<String> img;
		private final List<String> name;
		public DataBateSQListe dh;

		public MyPerformanceArrayAdapter(Activity context, List<String> name,List<String> img) {
			super(context, R.layout.showlistname, name);
			this.context = context;
			this.name = name;
			this.img = img;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View rowView = inflater.inflate(R.layout.showlistname, null, true);
			
			TextView textView = (TextView) rowView.findViewById(R.id.LableNmae);
			ImageView imgShow = (ImageView)rowView.findViewById(R.id.iconList);
			String i = img.get(position);
			String n = name.get(position);
			textView.setText(n);
			
			if (i.startsWith("man"))
				imgShow.setImageResource(R.drawable.man);
			else if (i.startsWith("women"))
				imgShow.setImageResource(R.drawable.women);
			else if (i.startsWith("boyfriends"))
				imgShow.setImageResource(R.drawable.boyfriends);
			else if (i.startsWith("girlfriends"))
				imgShow.setImageResource(R.drawable.girlfriends);
			else if (i.startsWith("brother"))
				imgShow.setImageResource(R.drawable.brother);
			else if (i.startsWith("sister"))
				imgShow.setImageResource(R.drawable.sister);
			else if (i.startsWith("boyfriend"))
				imgShow.setImageResource(R.drawable.boyfriend);
			else if (i.startsWith("girlfriend"))
				imgShow.setImageResource(R.drawable.girlfriend);
			else if(i.startsWith("noimg"))
				imgShow.setImageResource(R.drawable.noimg);
			
			imgShow.setVisibility(View.VISIBLE);

			return rowView;
		}
	}
}
