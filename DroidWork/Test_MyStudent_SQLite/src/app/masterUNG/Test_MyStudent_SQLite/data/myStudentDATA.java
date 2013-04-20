package app.masterUNG.Test_MyStudent_SQLite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class myStudentDATA {

	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;

	public static final String STUDENT_TABLE = "student_Table";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "Name";
	public static final String COLUMN_SURNAME = "Surname";
	public static final String COLUMN_SCHOOL = "School";

	public myStudentDATA(Context context) {
		dbHelper = new DatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
	}

	public long addNewStudent(String Name, String Surname, String School) {
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME, Name);
		values.put(COLUMN_SURNAME, Surname);
		values.put(COLUMN_SCHOOL, School);
		return database.insert(STUDENT_TABLE, null, values);

	}

	public Cursor readAllStudent() {
		Cursor mCursor = database.query(true, STUDENT_TABLE, new String[] {
				COLUMN_ID, COLUMN_NAME, COLUMN_SURNAME, COLUMN_SCHOOL }, null,
				null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	public int updateStudent(String id, String Name, String Surname,
			String School) {
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID, id);
		values.put(COLUMN_NAME, Name);
		values.put(COLUMN_SURNAME, Surname);
		values.put(COLUMN_SCHOOL, School);
		return database.update(STUDENT_TABLE, values, COLUMN_ID + "=?",
				new String[] { id });

	}

	public boolean deleteStudent(String id) {
		return database.delete(STUDENT_TABLE, COLUMN_ID + "=" + id, null) > 0;

	}

}
