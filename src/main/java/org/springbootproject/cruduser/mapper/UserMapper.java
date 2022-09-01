package org.springbootproject.cruduser.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springbootproject.cruduser.dto.UserAndUserProfileDTO;
import org.springbootproject.cruduser.entity.User;
import org.springbootproject.cruduser.entity.UserProfile;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    default User UserAndUserProfileDTOtoUser(UserAndUserProfileDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setMoney(dto.getMoney());

        UserProfile userProfile = new UserProfile();
        userProfile.setCountry(dto.getCountry());
        userProfile.setCity(dto.getCity());
        userProfile.setStreet(dto.getStreet());

        userProfile.setUser(user);
        user.setUserProfile(userProfile);
        return user;
    }
}
