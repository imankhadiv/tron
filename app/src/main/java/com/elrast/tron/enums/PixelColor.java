package com.elrast.tron.enums;

import android.graphics.Color;

/**
 * Created by Iman on 05/02/16.
 */
public enum PixelColor {

    BLACK(0), GREEN(1), RED(2), BLUE(3), YELLOW(4);

    int status;

    PixelColor(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


}
