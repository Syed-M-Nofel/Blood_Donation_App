package com.example.assignmet3;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mc.db";
    private static final int DATABASE_VERSION = 3;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Userdetails (name TEXT PRIMARY KEY, city TEXT, contact TEXT, dob TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            DB.execSQL("ALTER TABLE Userdetails ADD COLUMN city TEXT");
        }
        if (oldVersion < 3) {
            DB.execSQL("ALTER TABLE Userdetails ADD COLUMN email TEXT");
        }
    }

    public boolean insertUserData(String name, String city, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("city", city);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long result = db.insert("Userdetails", null, contentValues);
        db.close();
        return result != -1;
    }

    public boolean updateUserData(String name, String city, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("city", city);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = db.rawQuery("SELECT * FROM Userdetails WHERE name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = db.update("Userdetails", contentValues, "name=?", new String[]{name});
            db.close();
            return result != -1;
        } else {
            db.close();
            return false;
        }
    }

    public boolean deleteData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Userdetails WHERE name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = db.delete("Userdetails", "name=?", new String[]{name});
            db.close();
            return result != -1;
        } else {
            db.close();
            return false;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Userdetails", null);
        return cursor;
    }
}


