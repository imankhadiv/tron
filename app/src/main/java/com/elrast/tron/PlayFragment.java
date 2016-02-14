package com.elrast.tron;


import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.elrast.tron.database.TronDatabaseHelper;
import com.elrast.tron.enums.Direction;
import com.elrast.tron.enums.Level;
import com.elrast.tron.enums.Speed;
import com.elrast.tron.exceptions.CollisionException;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {
    interface CounterListener {
        int increment();
    }

    Context context;
    GridView gridView;
    private ImageAdapter imageAdapter;
    private boolean collision;
    private boolean shouldStart;
    private Speed speed = Speed.SLOW;
    private Direction direction = Direction.UP;
    private CounterListener counterListener;
    int counter = 0;
    private final static String SCORE = "SCORE";
    private final static String LEVEL = "LEVEL";
    private final static String STATUS = "STATUS";
    private Level level = Level.FIRST;


    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        this.context = inflater.getContext();
        this.gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setBackgroundColor(Color.BLACK);
        int y = gridView.getHeight();
        this.imageAdapter = new ImageAdapter(context);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(context, "" + position,
                        Toast.LENGTH_SHORT).show();
//                v.setBackgroundColor(Color.YELLOW);
            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PlayActivity) {
//            setCounterListener((PlayActivity)context);
            this.context = context;


        }
    }

    @Override
    public void onResume() {
        super.onResume();

        gridView.post(new Runnable() {

            Grid grid = new Grid();
            List<Integer> gridPixelList = grid.getPixelList();
            ComputerPlayer computerPlayer = new ComputerPlayer(gridPixelList);
            HumanPlayer humanPlayer = new HumanPlayer(gridPixelList);

            @Override
            public void run() {

                if (imageAdapter.gridsStatusNumbers == null) {
                    imageAdapter.gridsStatusNumbers = gridPixelList;
                }
                if (shouldStart) {
                    try {
                        computerPlayer.move();
                       // humanPlayer.move(direction);
                        if (counterListener != null) {
                            counter = counterListener.increment();
                        }

                    } catch (CollisionException e) {

                        Toast toast = Toast.makeText(context, counter + "" + e.getStatus(), Toast.LENGTH_LONG);
                        toast.show();
                        saveHistory(e.getStatus());
                        collision = true;
                    }
                }

                imageAdapter.gridsStatusNumbers = gridPixelList;
                imageAdapter.notifyDataSetChanged();
                if (collision) {
                    return;
                }
                gridView.postDelayed(this, speed.getTimeInterval());
            }

        });

    }

    public void saveHistory(String status) {

        TronDatabaseHelper tronDatabaseHelper = new TronDatabaseHelper(this.context);
        SQLiteDatabase db = tronDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE, counter);
        contentValues.put(LEVEL, level.getLevelNumber());
        contentValues.put(STATUS, status);
        db.insert("HISTORY", null, contentValues);
    }


    @Override
    public Context getContext() {
        return super.getContext();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setShouldStart(boolean shouldStart) {
        this.shouldStart = shouldStart;
    }

    public void setCounterListener(CounterListener counterListener) {
        this.counterListener = counterListener;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }


}
