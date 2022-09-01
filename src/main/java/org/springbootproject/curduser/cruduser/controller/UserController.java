package org.springbootproject.curduser.cruduser.controller;

import org.springbootproject.curduser.cruduser.entity.User;
import org.springbootproject.curduser.cruduser.exception.UserNotFoundException;
import org.springbootproject.curduser.cruduser.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id).orElseThrow(() -> new UserNotFoundException("can't find user by id: " + id));
    }

}
