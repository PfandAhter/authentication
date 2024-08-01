package intern.freedesk.authentication.rest.controller;

import intern.freedesk.authentication.api.AuthApi;
import intern.freedesk.authentication.api.request.AuthUserRequest;
import intern.freedesk.authentication.api.request.BaseRequest;
import intern.freedesk.authentication.api.request.UserAddRequest;
import intern.freedesk.authentication.api.response.AuthUserResponse;
import intern.freedesk.authentication.api.response.BaseResponse;
import intern.freedesk.authentication.api.response.UserEmailResponse;
import intern.freedesk.authentication.api.response.UserIdResponse;
import intern.freedesk.authentication.exceptions.NotFoundException;
import intern.freedesk.authentication.rest.service.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequiredArgsConstructor
@CrossOrigin

public class AuthServiceController implements AuthApi {

    private final AuthServiceImpl authService;

    @Override
    public ResponseEntity<AuthUserResponse> authUser(AuthUserRequest request) throws NotFoundException {
        return ResponseEntity.ok(authService.authUser(request));
    }

    @Override
    public ResponseEntity<BaseResponse> createUser(UserAddRequest request) {
        return ResponseEntity.ok(authService.createUser(request));
    }

    @Override
    public ResponseEntity<UserEmailResponse> getEmailFromUserId(String userId) throws NotFoundException {
        return ResponseEntity.ok(authService.userEmailByUserId(userId));
    }

    @Override
    public ResponseEntity<UserIdResponse> getUserIdFromEmail(String email) throws NotFoundException {
        return ResponseEntity.ok(authService.userIdResponse(email));
    }

    @Override
    public ResponseEntity<BaseResponse> logoutUser(BaseRequest baseRequest) {
        return ResponseEntity.ok(authService.logoutUser(baseRequest));
    }

    @Override
    public ResponseEntity<UserIdResponse> getUserRoleFromToken(String userId) throws NotFoundException {
        return ResponseEntity.ok(authService.extractRoleFromToken(userId));
    }
}