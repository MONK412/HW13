package ru.netology.manager;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) {
        super(s);
    }
}
