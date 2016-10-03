package com.amisha.mujeaseup;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.HashMap;

public class StudentInformationProvider extends ContentProvider {

    static final String PROVIDER_NAME="com.example.provider.Students";
    static final String URL="content://" +PROVIDER_NAME+ "/students";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String NAME = "name";
    static final String REGISTRATION = "regno";
    static final String YEAR = "year";
    static final String COURSE = "course";
    static final String ROOM = "room";
    static final String FROMDATE = "fromdate";
    static final String TODATE = "todate";
    static final String ADDRESS = "address";
    static final String PARENTSNUMBER = "pno";

    private static HashMap<String,String> STUDENTS_PROJECTION_MAP;
    static final int STUDENTS=1;
    static final int STUDENTS_ID=2;

    static UriMatcher uriMatcher=null;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"students",STUDENTS);
        uriMatcher.addURI(PROVIDER_NAME,"students/#",STUDENTS_ID);
    }

    private SQLiteDatabase db;
    static final String DATABASE_NAME="Students";
    static final String STUDENTS_TABLE_NAME="Students";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            "CREATE TABLE" + STUDENTS_TABLE_NAME +
                    "(regno INTEGER PRIMARY KEY," + "name UNIQUE ON CONFLICT REPLACE," +
                    "year," + "course," + "room," + "fromdate," + "todate," + "address," + "pno);";

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
             db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + STUDENTS_TABLE_NAME);
            onCreate(db);
        }
    }

    @Override
    public boolean onCreate() {
        Context context=getContext();
        DatabaseHelper dbHelper=new DatabaseHelper(context);
        db=dbHelper.getWritableDatabase();
        return (db!=null);
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        qb.setTables(STUDENTS_TABLE_NAME);
        switch(uriMatcher.match(uri)){
            case STUDENTS: qb.setProjectionMap(STUDENTS_PROJECTION_MAP);
                break;
            case STUDENTS_ID: qb.appendWhere(NAME + "=" +uri.getPathSegments().get(1));
                break;
            default: throw new IllegalArgumentException("Unknown Uri:" +uri);
        }
        if(sortOrder==null || sortOrder==""){
            sortOrder=REGISTRATION;
        }
        Cursor c=qb.query(db, projection,selection, selectionArgs,null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case STUDENTS:
                return "vnd.android.cursor.dir/vnd.example.exercises";

            case STUDENTS_ID:
                return "vnd.android.cursor.item/vnd.example.exercises";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID=db.insert(STUDENTS_TABLE_NAME,"",values);
        if(rowID>0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI,rowID);
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        throw new SQLException("Failed to add a record into:" +uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case STUDENTS:
                count = db.delete(STUDENTS_TABLE_NAME, selection, selectionArgs);
                break;

            case STUDENTS_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(STUDENTS_TABLE_NAME, NAME +  " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case STUDENTS:
                count = db.update(STUDENTS_TABLE_NAME, values, selection, selectionArgs);
                break;

            case STUDENTS_ID:
                count = db.update(STUDENTS_TABLE_NAME, values, NAME + " = " + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri );
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    public void clearTable()
    {
        db.execSQL("DELETE FROM Students");
    }
}
