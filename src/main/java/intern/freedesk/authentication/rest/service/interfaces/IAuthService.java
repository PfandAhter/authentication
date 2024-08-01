package intern.freedesk.authentication.rest.service.interfaces;

import intern.freedesk.authentication.api.request.AuthUserRequest;
import intern.freedesk.authentication.api.request.UserAddRequest;
import intern.freedesk.authentication.api.response.AuthUserResponse;
import intern.freedesk.authentication.api.response.BaseResponse;
import intern.freedesk.authentication.exceptions.NotFoundException;

public interface IAuthService {

    BaseResponse createUser (UserAddRequest request);

    AuthUserResponse authUser (AuthUserRequest request) throws NotFoundException;


}
