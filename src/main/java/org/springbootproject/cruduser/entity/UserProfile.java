package org.springbootproject.cruduser.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @JsonBackReference
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
