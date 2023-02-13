package ru.zhigalov.superkassa.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final String OBJECT_NOT_FOUND = "Object with id = %s not found";

    public ObjectNotFoundException(int id) {
        super(String.format(OBJECT_NOT_FOUND, id));
    }
}
