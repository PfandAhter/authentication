package intern.freedesk.authentication.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthUserRequest extends BaseRequest {

    private String email;

    private String password;
}
