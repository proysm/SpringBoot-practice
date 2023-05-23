package io.sumin.userrest.controller;


import io.sumin.userrest.entity.User;
import io.sumin.userrest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String register(@RequestBody User newUser){
        return userService.register(newUser);
    }

    @GetMapping("/users/{id}") //pass variable 특정경로에 id를 받아서 사용한다.
    public User find(@PathVariable String id){
        return userService.find(id);
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping("/users")
    public void modify(@RequestBody User newUser){
        userService.modify(newUser);
    }

    @DeleteMapping("/users/{id}")
    public void remove(@PathVariable String id){
        userService.remove(id);
    }
}
