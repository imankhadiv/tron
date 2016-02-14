package com.elrast.tron.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Iman on 07/02/16.
 */
public class TronDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "tron";
    private static final int DB_VERSION = 2;

    public TronDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db,0,DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db,oldVersion,newVersion);
    }

    public void updateMyDatabase(SQLiteDatabase database, int oldVersion, int newVersion) {
        if(oldVersion < 1) {
            database.execSQL("CREATE TABLE HISTORY ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "SCORE INTEGER, LEVEL INTEGER);");
        }
        if(oldVersion < 2) {
            database.execSQL("ALTER TABLE HISTORY ADD COLUMN STATUS TEXT;");
        }
    }
}
