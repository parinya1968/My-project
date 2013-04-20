package app.masterUNG.Test_MyStudent_SQLite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import app.masterUNG.Test_MyStudent_SQLite.data.myStudentDATA;

public class AddNewStudent extends Activity {

	private EditText edtName;
	private EditText edtSurName;
	private EditText edtSchool;

	private String strName;
	private String strSurname;
	private String strSchool;

	private myStudentDATA feedData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_student);
		initWidget();
		feedData = new myStudentDATA(this);
	}

	private void initWidget() {
		edtName = (EditText) findViewById(R.id.edtName);
		edtSurName = (EditText) findViewById(R.id.edtSurname);
		edtSchool = (EditText) findViewById(R.id.edtSchool);
	}

	public void ClickSaveNewStudent(View view) {

		strName = edtName.getText().toString();
		strSurname = edtSurName.getText().toString();
		strSchool = edtSchool.getText().toString();

		showAddStudentDialog();
		
	}

	private void showAddStudentDialog() {
		// TODO Auto-generated method stub
		AlertDialog.Builder addStudentAlert = new AlertDialog.Builder(this);
		addStudentAlert.setIcon(R.drawable.ewtc_list);
		addStudentAlert.setTitle("Add New Student to SQLite");
		addStudentAlert.setMessage("Name : " + strName + "\n" + "Surname : "
				+ strSurname + "\n" + "School : " + strSchool);

		addStudentAlert.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						addDataToSQLite();
					}
				});

		addStudentAlert.setNegativeButton("NO",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});

		addStudentAlert.show();

	}

	protected void addDataToSQLite() {

		long insertID = feedData.addNewStudent(strName, strSurname, strSchool);
		Log.d("feedDATA", "feed id = " + insertID);
		
		edtName.setText("");
		edtSurName.setText("");
		edtSchool.setText("");

	}

}
