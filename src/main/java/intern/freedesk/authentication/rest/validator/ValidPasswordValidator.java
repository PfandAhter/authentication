package intern.freedesk.authentication.rest.validator;

import intern.freedesk.authentication.rest.validator.annotations.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private final Pattern REGEX = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$");

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(REGEX.pattern(), value);
    }

}

