package com.elrast.tron;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Iman on 11/02/16.
 */
public class HistoryCursorAdapter extends CursorAdapter {
    private LayoutInflater layoutInflater;


    public HistoryCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }


    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return layoutInflater.inflate(R.layout.history_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView levelTextView = (TextView) view.findViewById(R.id.level);
        TextView scoreTextView = (TextView) view.findViewById(R.id.score);
        TextView statusTextView = (TextView) view.findViewById(R.id.status);

        levelTextView.setText(String.valueOf(cursor.getInt(1)));
        scoreTextView.setText(String.valueOf(cursor.getInt(2)));
        statusTextView.setText(cursor.getString(3));

    }
}

