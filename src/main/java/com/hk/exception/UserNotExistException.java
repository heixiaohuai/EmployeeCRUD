package com.hk.exception;

/**
 * @Classname UserNotExistException
 * @Description TODO
 * @Date 2019/8/23 14:50
 * @Created by 13055
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("User not exist exception!");
    }
}
