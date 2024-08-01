package intern.freedesk.authentication.rest.validator;

import intern.freedesk.authentication.rest.validator.annotations.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        return s.endsWith("@gmail.com") || s.endsWith("@outlook.com") || s.endsWith("@hotmail.com");
        return s.endsWith("@kkb.com.tr") || s.endsWith("@kkb.com");
    }

}