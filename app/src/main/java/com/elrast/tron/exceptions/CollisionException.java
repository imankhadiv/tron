package com.elrast.tron.exceptions;

/**
 * Created by Iman on 05/02/16.
 */
public class CollisionException extends Exception{

    private String status;
    public CollisionException(String reason, String statement, String status) {
        super(reason + " : " + statement);
        this.status = status;
    }
    public CollisionException(String reason, String statement, Throwable cause) {
        super(reason + " : " + statement, cause);

    }
    public String getStatus() {
        return this.status;
    }

}
