package com.application.persistence.entities;

import com.application.utils.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "role")
@SQLDelete(sql = "update role set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private UserType name;

    @ManyToMany(mappedBy = "roleTypes")
    private Collection<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "privilege_roles", joinColumns = @JoinColumn(name = "privilege_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "role_ID", referencedColumnName = "ID"))
    private Collection<Privilege> privileges;

    @Column
    private boolean delete = false;
}