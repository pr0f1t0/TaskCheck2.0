package com.pr0f1t.taskcheck.commands.user.login;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.exceptions.user.UserNotFoundException;
import com.pr0f1t.taskcheck.repository.UserRepository;
import com.pr0f1t.taskcheck.responses.LoginResponse;
import com.pr0f1t.taskcheck.security.jwt.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginUserService implements Command<LoginUserCommand, LoginResponse> {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final LoginUserCommandValidator validator;

    public LoginUserService(AuthenticationManager authenticationManager,
                            JwtService jwtService,
                            UserRepository userRepository, LoginUserCommandValidator validator) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public ResponseEntity<LoginResponse> execute(LoginUserCommand command) {

        validator.validate(command);

       Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
               command.getEmail(),
               command.getPassword()
       ));

       SecurityContextHolder.getContext().setAuthentication(authentication);

       User user = userRepository.findByEmail(command.getEmail())
               .orElseThrow(() -> new UserNotFoundException(UserErrorMessages.USER_NOT_FOUND.getMessage()));

       HashMap<String, Object> claims = new HashMap<>(Map.of("userId", user.getId()));

       String token = jwtService.generateToken(claims, user);

       LoginResponse loginResponse = LoginResponse.builder()
               .token(token)
               .build();

       return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }
}
