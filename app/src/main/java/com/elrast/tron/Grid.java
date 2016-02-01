package com.elrast.tron;

import com.elrast.tron.models.Pixel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iman on 01/02/16.
 */
public class Grid {

    public final static int HIDDEN = 0;
    public final static int GREEN = 1;
    public final static int RED = 2;
    public final static int BLUE = 3;


    private List<Integer> pixelList;

    public Grid() {
        pixelList = new ArrayList<>();
        for(int i = 0 ; i < 400 ; i++) {
            if(checkPixelStatus(i)){
                pixelList.add(i,HIDDEN);
            }
            else if(i == 130){
                pixelList.add(i,RED);
            }else if(i == 270) {
                pixelList.add(i,GREEN);
            }else{
                pixelList.add(i,BLUE);
            }
        }

    }
    private boolean checkPixelStatus(int position) {
            return ( (position <=20)|| (position %20 == 0) || (380 <= position && position <= 400) || ((position+1) % 20 == (0)));
        }
    public List<Integer> getPixelList() {
        return pixelList;
    }

}
