package com.application.persistence.repositories;

import com.application.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByID(long id);

    public User findUserByRoleType(long idRole);
}