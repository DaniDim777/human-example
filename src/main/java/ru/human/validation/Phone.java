package ru.human.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * создание пользовательской аннотации
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    /**
     * сообщение о некорректности входных данных
     *
     * @return дефолтное сообщение
     */
    String message() default "Phone is incorrect, please use pattern 'XXX-XX-XX'";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
