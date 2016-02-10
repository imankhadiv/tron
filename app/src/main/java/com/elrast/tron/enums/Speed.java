package com.elrast.tron.enums;

/**
 * Created by Iman on 10/02/16.
 */
public enum Speed {

    FAST(500), NORMAL(700), SLOW(1000);


    private long timeInterval;

    Speed(long timeInterval) {
        this.timeInterval = timeInterval;
    }

    public long getTimeInterval() {
        return timeInterval;
    }

}
