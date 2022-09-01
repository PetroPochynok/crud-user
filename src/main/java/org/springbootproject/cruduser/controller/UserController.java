package org.springbootproject.cruduser.controller;

import org.springbootproject.cruduser.dto.UserAndUserProfileDTO;
import org.springbootproject.cruduser.entity.User;
import org.springbootproject.cruduser.exception.UserNotFoundException;
import org.springbootproject.cruduser.mapper.UserMapper;
import org.springbootproject.cruduser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CRUD operations

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id).orElseThrow(() -> new UserNotFoundException("can't find user by id " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> saveUser(@RequestBody UserAndUserProfileDTO dto) {
        User user = UserMapper.INSTANCE.UserAndUserProfileDTOtoUser(dto);
        userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserAndUserProfileDTO dto, @PathVariable Long id) {
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid user id");
        }
        User updatedUser = userService.updateUser(dto, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User user = userService.getUser(id).orElseThrow(() -> new UserNotFoundException("there is no user by id " + id));
        userService.deleteUser(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    // business logic

    @GetMapping("/getPoorestUser")
    public User getPoorestUser() {
        return userService.getPoorestUser();
    }

    @GetMapping("/getRichestUser")
    public User getRichestUser() {
        return userService.getRichestUser();
    }

    @GetMapping("/getUsersByCountry")
    public List<User> getUsersByCountry(@RequestParam("country") String country) {
        return userService.getUsersByCountry(country);
    }

    @GetMapping("/getUsersByRangeMoney")
    public List<User> getUsersByRangeMoney(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
        return userService.getUsersByRangeMoney(min, max);
    }

    @GetMapping("/getUsersByFirstName")
    public List<User> getUsersByFirstName(@RequestParam("firstName") String firstName) {
        return userService.getUsersByFirstName(firstName);
    }

    @GetMapping("/getUsersByLastName")
    public List<User> getUsersByLastName(@RequestParam("lastName") String lastName) {
        return userService.getUsersByLastName(lastName);
    }

    @GetMapping("/getUsersByEmailDomain")
    public List<User> getUsersByEmailDomain(@RequestParam("domain") String domain) {
        return userService.getUsersByEmailDomain(domain);
    }

}
