package com.application.persistence.repositories;

import com.application.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByID(long id);

    public User findUserByRoleType(long idRole);
}