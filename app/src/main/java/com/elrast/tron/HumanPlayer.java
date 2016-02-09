package com.elrast.tron;

import com.elrast.tron.enums.Direction;
import com.elrast.tron.enums.PixelColor;
import com.elrast.tron.exceptions.CollisionException;

import java.util.List;

/**
 * Created by Iman on 05/02/16.
 */
public class HumanPlayer {

    private List<Integer> pixelList;
    private int headPosition = 270;


    public HumanPlayer(List<Integer> pixelList) {
        this.pixelList = pixelList;
    }

    public void move(Direction direction) throws CollisionException {

        switch (direction) {
            case UP:
                headPosition -= 20;
                break;
            case RIGHT:
                headPosition += 1;
                break;
            case DOWN:
                headPosition += 20;
                break;
            case LEFT:
                headPosition -= 1;
                break;
        }
        if (pixelList.get(headPosition) != PixelColor.BLUE.getStatus()) {
            pixelList.set(headPosition, PixelColor.YELLOW.getStatus());
            throw new CollisionException("Collision Exception Occurred: ", "Human Player Lost");
        }
        pixelList.set(headPosition, PixelColor.GREEN.getStatus());
    }
}
