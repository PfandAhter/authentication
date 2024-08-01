package intern.freedesk.authentication.api.response;


import intern.freedesk.authentication.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class AuthUserResponse {
    private String token;

    private Role role;

    private String firstName;
}
