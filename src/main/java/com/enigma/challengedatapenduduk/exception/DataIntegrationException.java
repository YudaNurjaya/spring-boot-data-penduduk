package com.enigma.challengedatapenduduk.exception;

public class DataIntegrationException extends RuntimeException{
    public DataIntegrationException(){
        super("Cannot delete this data because have constraint with others entities");
    }
    public DataIntegrationException(String message){
        super(message);
    }
}
