package com.application.persistence.entities;

import com.application.utils.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Enumerated(EnumType.STRING)
    private UserType name;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "privilege_roles", joinColumns = @JoinColumn(name = "privilege_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "role_ID", referencedColumnName = "ID"))
    private Collection<Privilege> privileges;

    @Column
    private boolean delete = false;
}