package com.application.persistence.repositories;

import com.application.persistence.entities.Discount;
import com.application.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    User findUserByID(long id);

    User findUserByRoleType(long idRole);
}