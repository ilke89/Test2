package com.example.ilkeutd.pametanpisebudalapamti;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMM_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String query = "create table contacts (id integer primary key not null , " +
"name text not null, email text not null, uname text not null, pass text not null );";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
        this.db = db;
    }

    public void addData(Contact c){


        db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        String queryId="select * from contacts ";
        Cursor cursor= db.rawQuery(queryId, null);
        int count=cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMM_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPassword());
        db.insert(TABLE_NAME, null, values);
        db.close();


    };

    public String logIn(String email){
        db=this.getReadableDatabase();
        String queryIn=" select * from " + TABLE_NAME;
        Cursor cursor=db.rawQuery(queryIn, null);
        String e,p;
        p="not found";

        if (cursor.moveToFirst())
        {
            do {
                e=cursor.getString(2);


                if (e.equals(email)){

                    p=cursor.getString(4);
                    break;
                }

            }
            while (cursor.moveToNext());
        }

        return  p;




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String queryUp="DROP TABLE IF EXISTS"+ TABLE_NAME;
        db.execSQL(queryUp);
        this.onCreate(db);

    }
}
