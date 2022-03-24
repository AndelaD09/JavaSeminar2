package com.application.persistence.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "user")
@SQLDelete(sql = "update user set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "role_ID", referencedColumnName = "ID"))
    private Collection<Role> roleTypes;

    @Column
    private boolean delete = false;

    @Column
    private boolean tokenExpired;
}