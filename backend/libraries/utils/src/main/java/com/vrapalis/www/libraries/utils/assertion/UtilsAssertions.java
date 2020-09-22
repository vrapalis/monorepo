package com.vrapalis.www.libraries.utils.assertion;

import com.vrapalis.www.libraries.utils.error.UtilsBeanValidationError;
import org.springframework.validation.BindingResult;

public final class UtilsAssertions {
    public UtilsAssertions() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void noBeanValidationErrors(final BindingResult result) {
        if (result.hasErrors()) {
            throw new UtilsBeanValidationError(result);
        }
    }
}
