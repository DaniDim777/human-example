package ru.human.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * создание ограничения пользовательской аннотации
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Phone phone) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(String enteredPhone, ConstraintValidatorContext constraintValidatorContext) {
        return enteredPhone.matches("\\d{3}-\\d{2}-\\d{2}");
    }
}
