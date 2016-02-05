package com.elrast.tron;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    Context context;
    GridView gridView;
    private ImageAdapter imageAdapter;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
         this.gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setBackgroundColor(Color.BLACK);
        int y = gridView.getHeight();
        this.imageAdapter = new ImageAdapter(context);
        gridView.setAdapter(imageAdapter);
//        gridView.post(new Runnable() {
//            final GridView gridView1 = gridView;
//            @Override
//
//            public void run() {
//                gridView1.setBackgroundColor(Color.BLACK);
//                gridView1.setAdapter(new ImageAdapter(context));
//            }
//        });

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
        this.context = context;
    }

    @Override
    public void onResume() {
        super.onResume();


        gridView.post(new Runnable() {
//            int i = 117;
            Grid grid = new Grid();
            List<Integer> pixels = grid.getPixelList();
            ComputerPlayer computerPlayer = new ComputerPlayer(pixels);

            @Override
            public void run() {
                if(imageAdapter.updatedPixels == null){
                    imageAdapter.updatedPixels = pixels;
                }
//                imageAdapter.updatedPixels.add(i++);

                computerPlayer.move();
                imageAdapter.updatedPixels = pixels;
//                ComputerPlayer computerPlayer = new ComputerPlayer()

                imageAdapter.notifyDataSetChanged();
                gridView.postDelayed(this,100);
            }

        });



    }
}
