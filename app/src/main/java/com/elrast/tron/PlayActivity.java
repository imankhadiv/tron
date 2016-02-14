package com.elrast.tron;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.elrast.tron.database.TronDatabaseHelper;
import com.elrast.tron.enums.Direction;
import com.elrast.tron.enums.Speed;

public class PlayActivity extends Activity implements PlayFragment.CounterListener {
    public static final String RESUME = "Resume";
    public static final String PAUSE = "Pause";
    private static final String EASY = "Easy";
    private static final String MEDIUM = "Medium";
    private static final String DIFFICULT = "Difficult";
    PlayFragment playFragment;
    private int counter;
    private String difficulty = "Easy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        difficulty = getIntent().getStringExtra(MainActivity.DIFFICULTY);
        start(null);
    }

    public void changeDirection(View view) {
        switch (view.getId()) {
            case R.id.up_button:
                playFragment.setDirection(Direction.UP);
                break;
            case R.id.right_button:
                playFragment.setDirection(Direction.RIGHT);
                break;
            case R.id.down_button:
                playFragment.setDirection(Direction.DOWN);
                Log.e("Down Button", view.getId() + "");
                break;
            default:
                playFragment.setDirection(Direction.LEFT);
                Log.e("Default", view.getId() + ".....");
                break;
        }
    }

    public void start(View view) {

        playFragment = new PlayFragment();
        if (view != null) {
            playFragment.setShouldStart(true);
            playFragment.setSpeed(getSpeed(difficulty));
            playFragment.setCounterListener(this);
        }
        counter = 0;
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_container, playFragment);
        tx.addToBackStack(null);
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tx.commit();
    }

    public void pause(View view) {
        if (counter == 0) {
            return;
        }
        Button button = (Button) findViewById(R.id.pause_button);
        if (button.getText().equals(PAUSE)) {
            button.setText(RESUME);
            playFragment.setShouldStart(false);
        } else {
            button.setText(PAUSE);
            playFragment.setShouldStart(true);
        }
    }

    @Override
    public int increment() {
        counter++;
        TextView textView = (TextView) findViewById(R.id.counter);
        textView.setText(counter + "");
        return counter;
    }

    private Speed getSpeed(String difficulty) {
        switch (difficulty) {
            case EASY:
                return Speed.SLOW;
            case DIFFICULT:
                return Speed.FAST;
            default:
                return Speed.NORMAL;
        }
    }


}
