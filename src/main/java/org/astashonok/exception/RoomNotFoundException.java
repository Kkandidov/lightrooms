package org.astashonok.exception;

import java.io.Serializable;

public class RoomNotFoundException extends Exception implements Serializable {

    private String message;

    public RoomNotFoundException(){
        this("Room is not available!");
    }

    public RoomNotFoundException(String message){
        this.message = System.currentTimeMillis() + ": " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}


