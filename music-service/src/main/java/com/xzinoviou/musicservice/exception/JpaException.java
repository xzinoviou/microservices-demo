package com.xzinoviou.musicservice.exception;

/**
 * @author xzinoviou
 * created 13/7/2019
 */
public class JpaException extends RuntimeException {

    public JpaException(String s) {
        super(s);
    }

    public JpaException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public JpaException(Throwable throwable) {
        super(throwable);
    }
}
