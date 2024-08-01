package intern.freedesk.authentication.api.response;

import intern.freedesk.authentication.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class UserIdResponse {

    private String userId;

    private Role role;
}
