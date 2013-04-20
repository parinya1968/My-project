package app.masterUNG.Test_MyStudent_SQLite;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import app.masterUNG.Test_MyStudent_SQLite.data.myStudentDATA;

public class ViewAllStudent extends ListActivity {

	private myStudentDATA myData;
	private SimpleCursorAdapter dbAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		myData = new myStudentDATA(this);
		Cursor studentList = myData.readAllStudent();
		String[] from = new String[] { myStudentDATA.COLUMN_NAME,
				myStudentDATA.COLUMN_SURNAME, myStudentDATA.COLUMN_SCHOOL };
		int[] target = new int[] { R.id.txtName, R.id.txtSurname };
		dbAdapter = new SimpleCursorAdapter(this, R.layout.show_list_layout,
				studentList, from, target);
		setListAdapter(dbAdapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		String strid = Long.toString(id);
		Log.d("clickItem", strid);

		Cursor selectStudentDetail = (Cursor) l.getItemAtPosition(position);
		String studentName = selectStudentDetail.getString(selectStudentDetail
				.getColumnIndex(myStudentDATA.COLUMN_NAME));
		String studentSurname = selectStudentDetail
				.getString(selectStudentDetail
						.getColumnIndex(myStudentDATA.COLUMN_SURNAME));
		String studentSchool = selectStudentDetail
				.getString(selectStudentDetail
						.getColumnIndex(myStudentDATA.COLUMN_SCHOOL));

		Log.d("studentName = ", studentName);
		Log.d("studentSurname = ", studentSurname);
		Log.d("studentSchool = ", studentSchool);

		AlertDialog.Builder showStudentAlert = new AlertDialog.Builder(this);
		showStudentAlert.setIcon(R.drawable.ewtc_list);
		showStudentAlert.setTitle("Student Detail");
		showStudentAlert.setMessage("Name : " + studentName + "\n"
				+ "Surname : " + studentSurname + "\n" + "School : "
				+ studentSchool);
		showStudentAlert.setPositiveButton("OK",
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
