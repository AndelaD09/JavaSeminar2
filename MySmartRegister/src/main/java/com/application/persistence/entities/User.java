package com.application.persistence.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    private Role roleType;

}