package com.example.floura.contentproviders_example2;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by floura on 28/10/17.
 */

public class EmployeeContentProvider extends ContentProvider {
    public final static String DB_NAME = "empdb";
    public final static String DB_TABLE= "emptable";
    MySQLdb mySQLdb;
    SQLiteDatabase sqLiteDatabase;
    public static Uri CONTENT_URI = Uri.parse("content:/com.example.floura.contentproviders_example2/"+DB_TABLE);

    @Override
    public boolean onCreate() {
        mySQLdb = new MySQLdb(getContext(), DB_TABLE, null,1);
        sqLiteDatabase = mySQLdb.getWritableDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(DB_TABLE);
        sqLiteQueryBuilder.query(sqLiteDatabase,projection,selection,selectionArgs,null,null,sortOrder);
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowid = sqLiteDatabase.insert(DB_TABLE,null,values);
        if(rowid>0){
            uri = ContentUris.withAppendedId(uri,rowid);
        }
        Log.i("uri",uri.toString());
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
    private class MySQLdb extends SQLiteOpenHelper {

        public MySQLdb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DB_TABLE, null,1);
        }

        public MySQLdb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table "+DB_TABLE+"(username text,job text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }


    }
}
