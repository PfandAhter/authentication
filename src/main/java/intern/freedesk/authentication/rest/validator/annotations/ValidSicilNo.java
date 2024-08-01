package intern.freedesk.authentication.rest.validator.annotations;

import intern.freedesk.authentication.rest.validator.ValidSicilNoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidSicilNoValidator.class})

public @interface ValidSicilNo {
    String message() default "SicilNo must be exactly 16 characters long";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
