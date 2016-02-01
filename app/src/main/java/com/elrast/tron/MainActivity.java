package com.elrast.tron;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.logging.Handler;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.e("Display Metrices->....", metrics.widthPixels + "");
        Log.e("Display Metrices->....",metrics.heightPixels+"");
        Log.e("Display Metrices->....",metrics.xdpi+"");
        Log.e("Display Metrices->....",metrics.ydpi+"");
        Log.e("Display Metrices->....", metrics.density + "");
        Log.e("Display Metrices->....", metrics.densityDpi + "");


        MainFragment mainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.fragment);



    }
}
