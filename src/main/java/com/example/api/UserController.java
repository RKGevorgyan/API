package com.example.api;

import com.example.api.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {

    private Map<UUID, User> userMap = new HashMap<>();

    @PostMapping("save")
    public UUID saveUser(@RequestBody User user) {
        UUID userId = UUID.randomUUID();
        user.setId(userId);
        userMap.put(userId, user);
        return userId;
    }

    @DeleteMapping("delete/{userId}")
    public UUID deleteUserById(@PathVariable UUID userId) {
        userMap.remove(userId);
        return userId;
    }

    @GetMapping("all")
    public Map<UUID, User> getAllUsers() {
        return userMap;
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable UUID userId) {
        return userMap.get(userId);
    }
}
