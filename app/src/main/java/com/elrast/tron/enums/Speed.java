package com.elrast.tron.enums;


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
