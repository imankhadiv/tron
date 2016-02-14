package com.elrast.tron;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.elrast.tron.database.TronDatabaseHelper;

public class HistoryActivity extends AppCompatActivity {

    public static final String HISTORY = "HISTORY";
    private TronDatabaseHelper tronDatabaseHelper;
    private SQLiteDatabase db;
    private Cursor cursor;
    private HistoryCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        new ShowHistoryTask().execute();
    }

    public void clearHistory(View view) {
        db = tronDatabaseHelper.getWritableDatabase();
        db.delete("HISTORY", null, null);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cursor != null) {
            cursor.close();
        }
        if (db != null) {
            db.close();
        }
    }

    private class ShowHistoryTask extends AsyncTask<Integer, Void, Boolean> {


        @Override
        protected Boolean doInBackground(Integer... params) {

            try {
                tronDatabaseHelper = new TronDatabaseHelper(HistoryActivity.this);
                db = tronDatabaseHelper.getReadableDatabase();
                cursor = db.query(HISTORY, new String[]{"_ID", "LEVEL", "SCORE", "STATUS"}, null, null, null, null, null);
                simpleCursorAdapter = new HistoryCursorAdapter(HistoryActivity.this,
                        cursor, 0);

                return true;
            } catch (SQLiteException ex) {
                return false;
            }
        }
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean) {
                ListView listView = (ListView) findViewById(R.id.history_list);
                listView.setAdapter(simpleCursorAdapter);
            } else {
                Toast toast = Toast.makeText(HistoryActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
