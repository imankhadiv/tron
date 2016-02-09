package com.elrast.tron.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Iman on 07/02/16.
 */
public class TronDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "tron";
    private static final int DB_VERSION = 1;

    public TronDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE HISTORY ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "SCORE INTEGER, LEVEL INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
