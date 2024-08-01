package intern.freedesk.authentication.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class UserEmailResponse {

    private String email;
}
