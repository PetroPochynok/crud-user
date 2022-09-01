package org.springbootproject.cruduser.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserAndUserProfileDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer money;
    private String country;
    private String city;
    private String street;
}
