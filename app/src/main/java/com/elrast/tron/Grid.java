package com.elrast.tron;

import com.elrast.tron.enums.PixelColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iman on 01/02/16.
 */
public class Grid {


    private List<Integer> pixelList;

    public Grid() {
        pixelList = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            if (checkPixelStatus(i)) {
                pixelList.add(i, PixelColor.BLACK.getStatus());
            } else if (i == 130) {
                pixelList.add(i, PixelColor.RED.getStatus());
            } else if (i == 270) {
                pixelList.add(i, PixelColor.GREEN.getStatus());
            } else {
                pixelList.add(i, PixelColor.BLUE.getStatus());
            }
        }

    }

    private boolean checkPixelStatus(int position) {
        return ((position <= 20) || (position % 20 == 0) || (380 <= position && position <= 400) || ((position + 1) % 20 == (0)));
    }

    public List<Integer> getPixelList() {
        return pixelList;
    }

}
