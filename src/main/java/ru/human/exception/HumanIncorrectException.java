package ru.human.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * класс для назначения сообщения в глобальной обработке исключения
 */
@Getter
@Setter
@NoArgsConstructor
public class HumanIncorrectException {

    /**
     * сообщение
     */
    private String info;
}
