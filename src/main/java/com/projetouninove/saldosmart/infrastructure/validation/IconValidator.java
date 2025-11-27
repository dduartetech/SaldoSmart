package com.projetouninove.saldosmart.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class IconValidator implements ConstraintValidator<Icon, String> {

    private final List<String> validIcons = List.of(
            "Dices",
            "Apple",
            "Bus",
            "Train",
            "Book",
            "Banknote");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.isBlank() || validIcons.contains(value);
    }

}