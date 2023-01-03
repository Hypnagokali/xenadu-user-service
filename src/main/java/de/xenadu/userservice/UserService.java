package de.xenadu.userservice;

import de.xenadu.userservice.persistence.UserInfo;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserInfo> getUserByEmail(String email);

}
