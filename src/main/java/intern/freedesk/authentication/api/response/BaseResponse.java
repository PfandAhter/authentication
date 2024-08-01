package intern.freedesk.authentication.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import intern.freedesk.authentication.lib.constants.Constants;
import intern.freedesk.authentication.lib.constants.ResponseStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class BaseResponse {

    private String resultCode = Constants.SUCCESS;

    private String message = Constants.SUCCESS;

}
