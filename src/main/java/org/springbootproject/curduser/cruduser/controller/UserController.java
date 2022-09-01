package org.springbootproject.curduser.cruduser.controller;

import org.springbootproject.curduser.cruduser.dto.UserAndUserProfileDTO;
import org.springbootproject.curduser.cruduser.entity.User;
import org.springbootproject.curduser.cruduser.exception.UserNotFoundException;
import org.springbootproject.curduser.cruduser.mapper.UserMapper;
import org.springbootproject.curduser.cruduser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return userService.getUser(id).orElseThrow(() -> new UserNotFoundException("can't find user by id " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveUser(@RequestBody UserAndUserProfileDTO dto) {
        User user = UserMapper.INSTANCE.UserAndUserProfileDTOtoUser(dto);
        userService.saveUser(user);
    }

}
