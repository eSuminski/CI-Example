package dev.suminki.ce;

public class BadConnection extends RuntimeException{
    public BadConnection(String message){
        super(message);
    }
}
