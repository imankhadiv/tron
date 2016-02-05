package com.elrast.tron;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.elrast.tron.enums.Direction;

import java.util.logging.Handler;

public class MainActivity extends Activity {

    MainFragment mainFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        Log.e("Display Metrices->....", metrics.widthPixels + "");
//        Log.e("Display Metrices->....",metrics.heightPixels+"");
//        Log.e("Display Metrices->....",metrics.xdpi+"");
//        Log.e("Display Metrices->....",metrics.ydpi+"");
//        Log.e("Display Metrices->....", metrics.density + "");
//        Log.e("Display Metrices->....", metrics.densityDpi + "");


        mainFragment = new MainFragment();
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_container,mainFragment);
        tx.addToBackStack(null);
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tx.commit();

    }

    public void changeDirection(View view) {
        switch (view.getId()) {
            case R.id.up_button:
                mainFragment.setDirection(Direction.UP);
                break;
            case R.id.right_button:
                mainFragment.setDirection(Direction.RIGHT);
                break;
            case R.id.down_button:
                mainFragment.setDirection(Direction.DOWN);
                Log.e("Down Button",view.getId()+"");
                break;
            default:
                mainFragment.setDirection(Direction.LEFT);
                Log.e("Default",view.getId()+".....");
                break;
        }
    }
}
