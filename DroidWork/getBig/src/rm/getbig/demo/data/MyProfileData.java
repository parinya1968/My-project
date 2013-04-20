package rm.getbig.demo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyProfileData {
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;

	public static final String PROFILES_TABLE = "profiles";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "Name";
	public static final String COLUMN_WEIGHT = "Weight";
	public static final String COLUMN_HEIGHT = "Height";

	public MyProfileData(Context context) {
		dbHelper = new DatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
	}

	//Method to add elements to table
	public long addNewProfiles(String Name, int Weight, int Height) {
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME, Name);
		values.put(COLUMN_WEIGHT, Weight);
		values.put(COLUMN_HEIGHT, Height);
		return database.insert(PROFILES_TABLE, null, values);

	}

	//Fetch All elements
	public Cursor readAllProfiles() {
		Cursor mCursor = database.query(true, PROFILES_TABLE, new String[] {
				COLUMN_ID, COLUMN_NAME, COLUMN_WEIGHT, COLUMN_HEIGHT }, null,
				null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	//Update existing data
	public int updateProfiles(String id, String Name, int Weight ,
			int Height) {
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID, id);
		values.put(COLUMN_NAME, Name);
		values.put(COLUMN_WEIGHT, Weight);
		values.put(COLUMN_HEIGHT, Height);
		return database.update(PROFILES_TABLE, values, COLUMN_ID + "=?",
				new String[] { id });

	}

	//Delete data
	public boolean deleteStudent(String id) {
		return database.delete(PROFILES_TABLE, COLUMN_ID + "=" + id, null) > 0;

	}
}
