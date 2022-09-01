package org.springbootproject.curduser.cruduser.service;

import org.springbootproject.curduser.cruduser.dto.UserAndUserProfileDTO;
import org.springbootproject.curduser.cruduser.entity.User;
import org.springbootproject.curduser.cruduser.entity.UserProfile;
import org.springbootproject.curduser.cruduser.exception.UserNotFoundException;
import org.springbootproject.curduser.cruduser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User updateUser(UserAndUserProfileDTO dto, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("can't find user by id " + id));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setMoney(dto.getMoney());

        UserProfile userProfile = new UserProfile();
        userProfile.setCountry(dto.getCountry());
        userProfile.setCity(dto.getCity());
        userProfile.setStreet(dto.getStreet());
        return user;
    }
}
