package ru.human.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * хендлер для глобальной обработки исключений
 */
@ControllerAdvice
public class HumanExceptionHandler {

    /**
     * обработка пользовательского исключения
     *
     * @param exception пользовательское исключение
     * @return вернуть нот фаунд
     */
    @ExceptionHandler
    public ResponseEntity<HumanIncorrectException> handleException(NoSuchHumanException exception) {
        HumanIncorrectException data = new HumanIncorrectException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    /**
     * обработка всех исключений
     *
     * @param exception все исключения
     * @return вернуть бэд реквест
     */
    @ExceptionHandler
    public ResponseEntity<HumanIncorrectException> handleException(Exception exception) {
        HumanIncorrectException data = new HumanIncorrectException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
