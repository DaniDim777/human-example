package ru.human.exception;

/**
 * создание пользовательского исключения, переопределение сообщения исключения
 */
public class NoSuchHumanException extends RuntimeException {

    public NoSuchHumanException(String message) {
        super(message);
    }
}
