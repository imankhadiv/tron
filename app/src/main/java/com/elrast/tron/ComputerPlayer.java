package com.elrast.tron;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Iman on 01/02/16.
 */
public class ComputerPlayer {
    private List<Integer> pixelList;
    private int headPosition = 130;

    public ComputerPlayer(List<Integer> pixelList){
        this.pixelList = pixelList;

    }
    public void move() {
        if(headPosition == 130){
            headPosition = 150;
            this.pixelList.set(headPosition, 2);
        }else{
            Log.e("head position",headPosition+"");
            List<Integer> possibleWays = move(headPosition);
            headPosition = predictNextWays(possibleWays);
            this.pixelList.set(headPosition, 2);
        }
    }
//    public int checkBorders(int headPosition){
//        int newHeadPosition = headPosition;
//        if(Border.LEFT_BORDER.contains(headPosition) && headPosition != 361){
//            newHeadPosition += 20;
//        }else if(Border.RIGHT_BORDER.contains(headPosition) && headPosition != 378){
//            newHeadPosition += 20;
//        }else if(Border.UPPER_BORDER.contains(headPosition) && headPosition != 21){
//            newHeadPosition += 1;
//        }else if(Border.LOWER_BORDER.contains(headPosition) && headPosition != 378){
//            newHeadPosition += 1;
//        }else {
//            newHeadPosition += 1;
//        }
//        return newHeadPosition;
//    }
    public List<Integer> move(int headPosition) {
        int newHeadPosition = headPosition;
        List<Integer> permittedMovement = new ArrayList<>();
        if((headPosition + 1) <= pixelList.size() && pixelList.get(headPosition + 1) == 3){
            permittedMovement.add(headPosition+1);
        }
        if((headPosition - 1) <= pixelList.size() && pixelList.get(headPosition - 1) == 3){
            permittedMovement.add(headPosition - 1);
        }if((headPosition + 20) <= pixelList.size() && pixelList.get(headPosition + 20) == 3){
            permittedMovement.add(headPosition + 20);
        }
        if((headPosition - 20) <= pixelList.size() && pixelList.get(headPosition - 20) == 3){
            permittedMovement.add(headPosition - 20);
        }
        if(permittedMovement.isEmpty()){
            //throws Exception
        }
        return permittedMovement;
    }
    public int predictNextWays(List<Integer> possibleWays) {
        List<Integer> highPriorityMovements = new ArrayList<>();
        List<Integer> fairPriorityMovements = new ArrayList<>();
        List<Integer> lowPriorityMovements = new ArrayList<>();
//        int possibleWaysCount = 0 ;
        for(Integer way: possibleWays) {
            List<Integer> pWays = move(way);
            switch (pWays.size()){
                case 1:
                    lowPriorityMovements.add(way);
                    break;
                case 2:
                    fairPriorityMovements.add(way);
                    break;
                case 3:
                    highPriorityMovements.add(way);
                    break;
                default:
                    Log.e("size",pWays.size()+">"+possibleWays.size());
                    // throws exception
                    break;
            }
        }
        if(highPriorityMovements.size() > 0){
            return highPriorityMovements.get(new Random().nextInt(highPriorityMovements.size()))  ;
        }else if(fairPriorityMovements.size() > 0) {
            return fairPriorityMovements.get(new Random().nextInt(fairPriorityMovements.size()));
        }else if(lowPriorityMovements.size() > 0){
            return lowPriorityMovements.get(new Random().nextInt(lowPriorityMovements.size()));
        }else{
            Log.e("Finla Pos",possibleWays.size()+"...."+possibleWays);
            possibleWays.get(0);
            return possibleWays.get(0);
        }
    }
}
