package com.elrast.tron.enums;

/**
 * Created by Iman on 11/02/16.
 */
public enum Level {

    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGHTH(8), NINTH(9), TENTH(10);


    private int levelNumber;
    Level(int levelNumber) {
        this.levelNumber = levelNumber;
    }
    public int getLevelNumber() {
        return levelNumber;
    }

}
