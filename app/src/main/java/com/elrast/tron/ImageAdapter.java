package com.elrast.tron;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Iman on 24/01/16.
 */
public class ImageAdapter extends BaseAdapter {
    List<Integer> selectedPixelsByComputer;
    List<Integer> selectedPixelsByPlayer;

    public interface OnImageBackGroundChanged {
        public void backgroundChanged(ImageView imageView);
    }
    public OnImageBackGroundChanged onImageBackGroundChanged;
    private Context context;
    private View convertView;
    private ViewGroup parent;

    public ImageAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return 324;
//        return mThumbIds.length;
    }

    public Object getItem(int position) {

        return getView(position,convertView,parent);
    }

    public long getItemId(int position) {

        return position + 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            Log.e("Parent.getWidth---->", String.valueOf(parent.getWidth()));
            Log.e("Parent.getWidth---->", String.valueOf(parent.getLayoutParams().width));
            int parentWidth = parent.getWidth();

            // to convert dp to pix
            Resources resources = context.getResources();
            DisplayMetrics metrics = resources.getDisplayMetrics();
            int w = parent.getWidth();
            int y = parent.getHeight();
            int z = parent.getWidth();

            float my = 17 * (metrics.densityDpi / 160f);
            imageView.setLayoutParams(new GridView.LayoutParams((parentWidth - Math.round(my) ) / 18 , (parentWidth - Math.round(my)) / 18));

            imageView.setContentDescription("De");
            imageView.setBackgroundColor(Color.BLUE);

        } else {
            imageView = (ImageView) convertView;
            this.convertView = (ImageView)convertView;
            this.parent = parent;
            imageView.setBackgroundColor(Color.BLUE);

        }
//        if(selectedPixelsByComputer != null && selectedPixelsByComputer.contains(position)){
//            imageView.setBackgroundColor(Color.RED);
//        }
        if(selectedPixelsByComputer != null){
            switch (Math.round(selectedPixelsByComputer.get(Math.round(getItemId(position))))){
                case 1:
                    imageView.setBackgroundColor(Color.RED);
                    break;
                case 2:
                    imageView.setBackgroundColor(Color.GREEN);
                    break;
                case 3:
                    imageView.setBackgroundColor(Color.BLUE);
                    break;
            }
        }

        return imageView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        Log.e("..............","This is Observer");
        super.registerDataSetObserver(observer);
    }
}
