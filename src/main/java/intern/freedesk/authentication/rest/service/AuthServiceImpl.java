package intern.freedesk.authentication.rest.service;

import intern.freedesk.authentication.api.client.TokenServiceClient;
import intern.freedesk.authentication.api.request.AuthUserRequest;
import intern.freedesk.authentication.api.request.BaseRequest;
import intern.freedesk.authentication.api.request.UserAddRequest;
import intern.freedesk.authentication.api.response.AuthUserResponse;
import intern.freedesk.authentication.api.response.BaseResponse;
import intern.freedesk.authentication.api.response.UserEmailResponse;
import intern.freedesk.authentication.api.response.UserIdResponse;
import intern.freedesk.authentication.exceptions.NotFoundException;
import intern.freedesk.authentication.model.Role;
import intern.freedesk.authentication.model.Status;
import intern.freedesk.authentication.model.entity.User;
import intern.freedesk.authentication.repository.UserRepository;
import intern.freedesk.authentication.rest.service.interfaces.IAuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;


@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final TokenServiceClient tokenServiceClient;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public BaseResponse createUser(UserAddRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setActive(1);

        Timestamp timestamp1 = Timestamp.from(Instant.now());
        Timestamp timestamp2 = Timestamp.from(Instant.now());
        user.setPasswordLastChangedDate(timestamp1);
        timestamp2.setMonth(timestamp2.getMonth() + 2);
        user.setPasswordExpireDate(timestamp2);

        this.userRepository.save(user);

        return new BaseResponse();
    }

    @Override
    public AuthUserResponse authUser(AuthUserRequest request) throws NotFoundException {
        User user = userRepository.findByEmail(request.getEmail());

        if (user == null && !Status.ACTIVE.equals(user.getActive())) {
            throw new NotFoundException("USER NOT FOUND OR NOT ACTIVE");
        }

        //Bu userdetails kisminda duzeltilmis olabilir tekrar check et.

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        AuthUserResponse response = tokenServiceClient.generateToken(request);

        return AuthUserResponse.builder()
                .token(response.getToken())
                .role(user.getRole())
                .firstName(user.getFirstName())
                .build();
    }


    public UserEmailResponse userEmailByUserId (String userId) throws NotFoundException {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new NotFoundException("USER NOT FOUND");
        }
        return UserEmailResponse.builder()
                .email(user.getEmail())
                .build();
    }


    public UserIdResponse userIdResponse (String email) throws NotFoundException{
        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new NotFoundException("USER NOT FOUND");
        }
        return UserIdResponse.builder()
                .userId(user.getUserId())
                .role(user.getRole())
                .build();
    }


    public BaseResponse logoutUser (BaseRequest request){
        return tokenServiceClient.logoutUser(request);
    }


    public UserIdResponse extractRoleFromToken (String userId) throws NotFoundException {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new NotFoundException("USER NOT FOUND");
        }
        return UserIdResponse.builder()
                .role(user.getRole())
                .build();
    }

}
