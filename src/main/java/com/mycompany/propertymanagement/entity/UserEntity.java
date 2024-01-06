package com.mycompany.propertymanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivilegedAction;

@Entity
@Table(name = "USER_TABLE")
@Setter
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ownerName;
    @Column(name = "EMAIL", nullable = false)
    private String ownerEmail;
    private String phone;
    @Column(nullable = false)
    private String password;
}
