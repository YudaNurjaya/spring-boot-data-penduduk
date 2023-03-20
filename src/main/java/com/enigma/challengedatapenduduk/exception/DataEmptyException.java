package com.enigma.challengedatapenduduk.exception;

public class DataEmptyException extends RuntimeException{
    public DataEmptyException(){
        super("Data is empty");
    }
    public DataEmptyException(String message){
        super(message);
    }
}
