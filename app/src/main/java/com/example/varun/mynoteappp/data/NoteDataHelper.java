package com.example.varun.mynoteappp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by varun on 29/9/16.
 */

public class NoteDataHelper extends SQLiteOpenHelper {

    private static final String TAG = "NoteDataHelper";
    private static final String DATABASE_NAME = "Note.db";
    private static final String TABLE_NAME = "note_table";
    private static final int DATABASE_VERSION = 1;
    private static final String NOTE_ID = "note_id";
    private static final String NOTE_TIME = "time";
    private Context mContext;

    private static NoteDataHelper dbHelper;
    private static final Object lock = new Object();
    public static NoteDataHelper getInstance(Context context) {
        if(dbHelper == null) {
            synchronized (lock) {
                if(dbHelper == null)
                    dbHelper = new NoteDataHelper(context);
            }
        }
        return dbHelper;
    }

    private NoteDataHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (" + NOTE_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT ," +
                "description TEXT ," +
                "time INTEGER" +");");
    }

    public void add(String name,String decription,long time) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("time",time);
        values.put("description",decription);
        db.insert(TABLE_NAME,null,values);
    }

    public Cursor getNotesBefore(long time) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(TABLE_NAME,null,"where time <= ?",new String[]{String.valueOf(time)},null,null,null);
    }

    public Cursor getNotesAfter(long time) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(TABLE_NAME,null,"where time > ?",new String[]{String.valueOf(time)},null,null,null);
    }

    public static String getName(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("name"));
    }

    public static String getDescription(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("description"));
    }

    public static long getTime(Cursor cursor) {
        return cursor.getLong(cursor.getColumnIndex("time"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
