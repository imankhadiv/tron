package com.elrast.tron.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iman on 01/02/16.
 */
public class Border {

    public static final List<Integer> LEFT_BORDER = generateBorder(21,361,0);
    public static final List<Integer> RIGHT_BORDER = generateBorder(38,378,0);
    public static final List<Integer> UPPER_BORDER = generateBorder(21,38,1);
    public static final List<Integer> LOWER_BORDER = generateBorder(361,378,1);



    private static List<Integer> generateBorder(int start, int end, int direction){
        List<Integer> list = new ArrayList<>();
        // left and right border
        if(direction == 0) {
            for(int i = start; i <= end; i+=20 ){
                list.add(i);
            }
        }
        // upper and lower border
        if(direction == 1) {
            for(int i = start; i <= end; i+=1 ){
                list.add(i);
            }
        }
        return list;
    }
}
