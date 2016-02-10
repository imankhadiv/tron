package com.elrast.tron;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setSubtitle("Try It");

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                prepareBackToParentActivity();
                return true;
            default:
                System.out.println("hello world!");
        }
        return super.onOptionsItemSelected(item);
    }

    private void prepareBackToParentActivity() {
        Spinner spinner = (Spinner) findViewById(R.id.difficulty_spinner);
        String difficulty = (String) spinner.getSelectedItem();

        Intent intent = new Intent();
        intent.putExtra("difficulty", difficulty);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            prepareBackToParentActivity();
        }
        return super.onKeyDown(keyCode, event);
    }
}
