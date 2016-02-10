package com.elrast.tron;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.elrast.tron.enums.Speed;

public class MainActivity extends AppCompatActivity {

    public static final int SETTINGS_REQUEST = 1;
    public static final String DIFFICULTY = "difficulty";
    private String difficulty = "Easy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settingsBtn = (Button)findViewById(R.id.settings);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivityForResult(intent, SETTINGS_REQUEST);
            }
        });

        Button startBtn = (Button)findViewById(R.id.play);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlayActivity.class);
                intent.putExtra(DIFFICULTY,difficulty);
                startActivity(intent);
            }
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //call some material design API here
        }else{

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SETTINGS_REQUEST) {
            if(resultCode == RESULT_OK){
                difficulty = data.getStringExtra(DIFFICULTY);
            }
        }
    }
}
