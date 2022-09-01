package org.springbootproject.curduser.cruduser.service;

import org.springbootproject.curduser.cruduser.dto.UserAndUserProfileDTO;
import org.springbootproject.curduser.cruduser.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUser(Long id);

    void deleteUser(User user);

    void saveUser(User user);

    User updateUser(UserAndUserProfileDTO dto, Long id);

    User getPoorestUser();

    User getRichestUser();

    List<User> getUsersByCountry(String country);

    List<User> getUsersByRangeMoney(Integer min, Integer max);

    List<User> getUsersByFirstName(String firstName);

    List<User> getUsersByLastName(String lastName);

    List<User> getUsersByEmailDomain(String domain);
}
