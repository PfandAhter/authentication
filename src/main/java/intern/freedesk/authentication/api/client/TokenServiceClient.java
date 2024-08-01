package intern.freedesk.authentication.api.client;


import intern.freedesk.authentication.api.request.AuthUserRequest;
import intern.freedesk.authentication.api.request.BaseRequest;
import intern.freedesk.authentication.api.response.AuthUserResponse;
import intern.freedesk.authentication.api.response.BaseResponse;
import intern.freedesk.authentication.api.response.UserIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "TokenService" , url = "${client.feign.token-service.path}")
public interface TokenServiceClient {

    @PostMapping("${client.feign.token-service.generateToken}")
    AuthUserResponse generateToken (@RequestBody AuthUserRequest authUserRequest);

    @PostMapping("${client.feign.token-service.logoutUser}")
    BaseResponse logoutUser (@RequestBody BaseRequest baseRequest);



}
