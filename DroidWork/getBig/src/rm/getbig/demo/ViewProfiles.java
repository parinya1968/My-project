package rm.getbig.demo;

import rm.getbig.demo.data.MyProfileData;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewProfiles extends ListActivity {
	private MyProfileData myData;
	private SimpleCursorAdapter dbAdapter;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		myData = new MyProfileData(this);
		Cursor studentList = myData.readAllProfiles();
		String[] from = new String[] { MyProfileData.COLUMN_NAME,
				MyProfileData.COLUMN_WEIGHT, MyProfileData.COLUMN_HEIGHT };
		int[] target = new int[] { R.id.txtName, R.id.txtWeight, R.id.txtHeight };
		dbAdapter = new SimpleCursorAdapter(this, R.layout.viewprofiles,studentList, from, target);
		setListAdapter(dbAdapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		String strid = Long.toString(id);
		Log.d("clickItem", strid);

		//Wait for test change it to int
		Cursor selectStudentDetail = (Cursor) l.getItemAtPosition(position);
		String profileName = selectStudentDetail.getString(selectStudentDetail
				.getColumnIndex(MyProfileData.COLUMN_NAME));
		String profileWeight = selectStudentDetail
				.getString(selectStudentDetail
						.getColumnIndex(MyProfileData.COLUMN_WEIGHT));
		String profileHeight = selectStudentDetail
				.getString(selectStudentDetail
						.getColumnIndex(MyProfileData.COLUMN_HEIGHT));

		Log.d("Name = ", profileName);
		Log.d("Weight = ", profileWeight);
		Log.d("Height = ", profileHeight);

		AlertDialog.Builder showStudentAlert = new AlertDialog.Builder(this);
		showStudentAlert.setIcon(R.drawable.ewtc_list);
		showStudentAlert.setTitle("Profile Detail");
		showStudentAlert.setMessage("Name : " + profileName + "\n"
				+ "Weight : " + profileWeight + "\n" + "Height : "
				+ profileHeight);
		showStudentAlert.setPositiveButton("DELETE",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
		showStudentAlert.show();

	}

}
