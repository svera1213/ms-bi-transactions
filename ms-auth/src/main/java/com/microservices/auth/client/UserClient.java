package com.microservices.auth.client;

import com.microservices.auth.dto.ClientRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-user", url = "microservice-users:8090")
public interface UserClient {

    @PostMapping("/api/users")
    void saveUser(@RequestBody ClientRequest clientRequest);
}
