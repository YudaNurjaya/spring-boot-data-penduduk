package com.enigma.challengedatapenduduk.exception;

public class FailedToRunException extends RuntimeException{
    public FailedToRunException(){
        super("Failed to run");
    }
    public FailedToRunException(String message){
        super(message);
    }
}
