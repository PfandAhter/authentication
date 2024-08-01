package intern.freedesk.authentication.api;


import intern.freedesk.authentication.api.request.AuthUserRequest;
import intern.freedesk.authentication.api.request.BaseRequest;
import intern.freedesk.authentication.api.request.UserAddRequest;
import intern.freedesk.authentication.api.response.AuthUserResponse;
import intern.freedesk.authentication.api.response.BaseResponse;
import intern.freedesk.authentication.api.response.UserEmailResponse;
import intern.freedesk.authentication.api.response.UserIdResponse;
import intern.freedesk.authentication.exceptions.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface AuthApi {

    @PostMapping("/login")
    ResponseEntity<AuthUserResponse> authUser( @Valid @RequestBody AuthUserRequest request) throws NotFoundException;

    @PostMapping("/register")
    ResponseEntity<BaseResponse> createUser(@Valid @RequestBody UserAddRequest request);

    @GetMapping("/get/email")
    ResponseEntity<UserEmailResponse> getEmailFromUserId(@NotBlank @PathVariable ("userid") String userId) throws NotFoundException;

    @GetMapping("/get/userId")
    ResponseEntity<UserIdResponse> getUserIdFromEmail (@NotBlank @RequestParam ("email") String email) throws NotFoundException;

    @PostMapping("logout")
    ResponseEntity<BaseResponse> logoutUser(@Valid @RequestBody BaseRequest baseRequest);

    @GetMapping("/get/role")
    ResponseEntity<UserIdResponse> getUserRoleFromToken (@PathVariable("userId") String userId) throws NotFoundException;

}
