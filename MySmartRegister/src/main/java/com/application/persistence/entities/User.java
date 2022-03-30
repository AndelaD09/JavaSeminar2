package com.application.persistence.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Table(name = "user")
@SQLDelete(sql = "update user set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    private List<Role> roles;

    @Column
    private boolean delete = false;

    @Transient
    private double cash;

    @Column
    private boolean tokenExpired;
}