package com.application.persistence.repositories;

import com.application.persistence.entities.Discount;
import com.application.persistence.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>, PagingAndSortingRepository<Privilege, Long> {
    Privilege findByName(String name);
}