package telephone.sqlite.android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBateSQListe{

	private static final String DATABASE_NAME = "mydbbook.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "nodebook";

	private Context context;
	private SQLiteDatabase db;

	private SQLiteStatement insertStmt;
	private static final String INSERT = "insert into " + TABLE_NAME
			+ "(name,number,img) values (?,?,?)";

	public DataBateSQListe(Context context) {
		this.context = context;
		OpenHelper openHelper = new OpenHelper(this.context);
		this.db = openHelper.getWritableDatabase();
		this.insertStmt = this.db.compileStatement(INSERT);
	}

	public long insert(String name, String number, String img) {
		this.insertStmt.bindString(1, name);
		this.insertStmt.bindString(2, number);
		this.insertStmt.bindString(3, img);
		return this.insertStmt.executeInsert();
	}
	
	public void delete_byID(int id){
        this.db.delete(TABLE_NAME, "id ="+id, null);
 	}

	public ItemNode selectAll() {
		List<String> name = new ArrayList<String>();
		List<String> number = new ArrayList<String>();
		List<String> img = new ArrayList<String>();
		
		Cursor cursor = this.db.query(TABLE_NAME, new String[] { "*" },
				null, null, null, null, "id desc");
		if (cursor.moveToFirst()) {
			do {				
				name.add(cursor.getString(1));
				number.add(cursor.getString(2));
				img.add(cursor.getString(3));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		ItemNode list = new ItemNode();
		list.name = name;
		list.number = number;
		list.img = img;
		
		return list;
	}
	public int countColumns(String columns,String value){
		 String select = columns+" like " + "'"+value+"'";
		
		List<String> list = new ArrayList<String>();
		Cursor cursor = this.db.query(TABLE_NAME, new String[] { "*" },
				select, null, null, null, "id desc");
		if (cursor.moveToFirst()) {
			do {				
				list.add(cursor.getString(1));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return list.size();
	}
	
	public String showData(String name,int colum){
		String select = "name like " + "'"+name+"'";
		Cursor cursor = this.db.query(TABLE_NAME, new String[] { "*" },
				select, null, null, null, "id desc");
		List<String> list = new ArrayList<String>();
		if (cursor.moveToFirst()) {
			do {				
				list.add(cursor.getString(colum));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		String value = list.get(0);
		return value;
	}

	private static class OpenHelper extends SQLiteOpenHelper {

		OpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
      public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + TABLE_NAME + 
			          "(id integer primary key autoincrement," +
			          " name TEXT(55)," +
			          "number TEXT(11)," +
			          "img TEXT(55));");
      }

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("Example",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
	}
}
