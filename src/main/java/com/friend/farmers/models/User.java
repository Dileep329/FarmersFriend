package com.friend.farmers.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "userName"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String email;
    private String mobileNumber;
    private String pancard;
    private String password;

    public User(String userName, String mail, String number, String pancard1, String password1) {
        this.userName = userName;
        this.email = mail;
        this.mobileNumber = number;
        this.pancard = pancard;
        this.pancard = password1;
    }

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            orphanRemoval = true)
    private Set<Product> products;



}
