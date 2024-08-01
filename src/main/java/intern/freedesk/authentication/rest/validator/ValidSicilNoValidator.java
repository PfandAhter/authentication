package intern.freedesk.authentication.rest.validator;

import intern.freedesk.authentication.rest.validator.annotations.ValidSicilNo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidSicilNoValidator implements ConstraintValidator<ValidSicilNo, String> {

    @Override
    public void initialize(ValidSicilNo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String sicilNo, ConstraintValidatorContext constraintValidatorContext) {
        return sicilNo != null && sicilNo.length() == 16;
    }

}
