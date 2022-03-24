package com.application.persistence.repositories;

import com.application.persistence.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface RoleRepository extends JpaRepository<Role, Long> {
}