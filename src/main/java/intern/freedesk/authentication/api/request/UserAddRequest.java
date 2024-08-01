package intern.freedesk.authentication.api.request;

import intern.freedesk.authentication.lib.constants.ErrorCodeConstants;
import intern.freedesk.authentication.rest.validator.annotations.UniqueEmail;
import intern.freedesk.authentication.rest.validator.annotations.ValidEmail;
import intern.freedesk.authentication.rest.validator.annotations.ValidPassword;
import intern.freedesk.authentication.rest.validator.annotations.ValidSicilNo;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddRequest {

    @UniqueEmail(message = ErrorCodeConstants.EMAIL_IN_USE)
    @ValidEmail(message = ErrorCodeConstants.EMAIL_NOT_VALID)
    @NotEmpty(message = ErrorCodeConstants.EMAIL_NOT_NULL)
    private String email;

    @ValidSicilNo(message = ErrorCodeConstants.SICIL_NO_NOT_VALID_LENGTH)
    @NotEmpty(message = ErrorCodeConstants.SICIL_NO_NOT_NULL)
    private String sicilNo;

    @NotEmpty(message = ErrorCodeConstants.PASSWORD_NOT_NULL)
    @ValidPassword(message = ErrorCodeConstants.PASSWORD_NOT_VALID)
    private String password;

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

}
