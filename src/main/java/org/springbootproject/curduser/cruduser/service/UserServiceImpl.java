package org.springbootproject.curduser.cruduser.service;

import org.springbootproject.curduser.cruduser.dto.UserAndUserProfileDTO;
import org.springbootproject.curduser.cruduser.entity.User;
import org.springbootproject.curduser.cruduser.exception.UserNotFoundException;
import org.springbootproject.curduser.cruduser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User updateUser(UserAndUserProfileDTO dto, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("can't find user by id " + id));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setMoney(dto.getMoney());

        user.getUserProfile().setCountry(dto.getCountry());
        user.getUserProfile().setCity(dto.getCity());
        user.getUserProfile().setStreet(dto.getStreet());
        return user;
    }

    @Override
    public User getPoorestUser() {
        return userRepository.findAll()
                .stream()
                .min(comparing(User::getMoney))
                .orElseThrow();
    }

    @Override
    public User getRichestUser() {
        return userRepository.findAll()
                .stream()
                .max(comparing(User::getMoney))
                .orElseThrow();
    }

    @Override
    public List<User> getUsersByCountry(String country) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUserProfile().getCountry().equalsIgnoreCase(country))
                .collect(toList());
    }

    @Override
    public List<User> getUsersByRangeMoney(Integer min, Integer max) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getMoney() >= min && user.getMoney() <= max)
                .sorted(comparing(User::getMoney))
                .collect(toList());
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getFirstName().equalsIgnoreCase(firstName))
                .sorted(comparing(User::getFirstName).thenComparing(User::getLastName))
                .collect(toList());
    }

    @Override
    public List<User> getUsersByLastName(String lastName) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getLastName().equalsIgnoreCase(lastName))
                .sorted(comparing(User::getLastName).thenComparing(User::getFirstName))
                .collect(toList());
    }
}
