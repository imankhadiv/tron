package com.elrast.tron.exceptions;

/**
 * Created by Iman on 05/02/16.
 */
public class CollisionException extends Exception{

    public CollisionException(String reason, String statement) {
        super(reason + " : " + statement);
    }
    public CollisionException(String reason, String statement, Throwable cause) {
        super(reason + " : " + statement, cause);

    }

}
