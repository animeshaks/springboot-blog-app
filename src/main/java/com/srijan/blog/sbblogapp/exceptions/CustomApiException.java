package com.srijan.blog.sbblogapp.exceptions;

public class CustomApiException extends RuntimeException{

    public CustomApiException() {
        super();
    }

    public CustomApiException(String message) {
        super(message);
    }

}
