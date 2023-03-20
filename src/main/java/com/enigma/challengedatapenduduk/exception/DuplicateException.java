package com.enigma.challengedatapenduduk.exception;

public class DuplicateException extends RuntimeException{
    public DuplicateException(){
        super("Data is already exist");
    }
    public DuplicateException(String message){
        super(message);
    }
}
