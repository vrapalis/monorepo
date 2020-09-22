package com.vrapalis.www.libraries.utils.error;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class UtilsBeanValidationError extends UtilsError {
    @Getter
    private final Map<String, String> errors = new HashMap<>();

    public UtilsBeanValidationError(BindingResult result) {
        super("Bean validation errors: " + result.toString());
        result.getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
    }
}
