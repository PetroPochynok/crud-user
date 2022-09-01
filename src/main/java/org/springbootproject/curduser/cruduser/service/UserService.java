package org.springbootproject.curduser.cruduser.service;

import org.springbootproject.curduser.cruduser.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();

    Optional<User> getUser(Long id);

    void deleteUser(User user);

    void saveUser(User user);
}
