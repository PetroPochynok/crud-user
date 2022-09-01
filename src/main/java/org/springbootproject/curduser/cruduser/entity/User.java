package org.springbootproject.curduser.cruduser.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "money")
    private Integer money;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserProfile userProfile;
}
