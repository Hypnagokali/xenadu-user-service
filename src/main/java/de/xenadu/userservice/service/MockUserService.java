package de.xenadu.userservice.service;

import de.xenadu.userservice.UserService;
import de.xenadu.userservice.persistence.UserInfo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MockUserService implements UserService {

    @Override
    public Mono<UserInfo> getUserByEmail(String email) {
        if (email.equalsIgnoreCase("test@test.de")) {
            final UserInfo userInfo = new UserInfo();
            userInfo.setId(12);
            userInfo.setEmail("test@test.de");
            userInfo.setFirstName("Tessa");
            userInfo.setLastName("Testerin");

            return Mono.just(userInfo);
        }

        if (email.equalsIgnoreCase("test@example.org")) {
            final UserInfo userInfo = new UserInfo();
            userInfo.setId(1);
            userInfo.setEmail("test@example.org");
            userInfo.setFirstName("Stefan");
            userInfo.setLastName("Simon");

            return Mono.just(userInfo);
        }


        return Mono.empty();
    }
}
