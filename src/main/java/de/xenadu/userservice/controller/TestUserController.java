package de.xenadu.userservice.controller;

import de.xenadu.userservice.UserService;
import de.xenadu.userservice.persistence.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestUserController {

    private final UserService userService;

    @ExceptionHandler({ RestBadRequestException.class })
    public ResponseEntity<ApiError> handleBadRequestException(Exception e) {
        return ResponseEntity.badRequest().body(new ApiError(400, e.getMessage()));
    }


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON)
    public String baseMapping() {
        return """
                {
                    "response": "hello from user service"
                }
                """;
    }

    @GetMapping("/users/{email}")
    public Mono<UserInfo> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .switchIfEmpty(Mono.error(new RestBadRequestException("User not found")));
    }

}
