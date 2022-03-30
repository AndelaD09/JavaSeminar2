package com.application.persistence.repositories;

import com.application.persistence.entities.Discount;
import com.application.persistence.entities.Role;
import com.application.utils.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface RoleRepository extends JpaRepository<Role, Long>, PagingAndSortingRepository<Role, Long> {
    Role findRoleByName(UserType userType);
}