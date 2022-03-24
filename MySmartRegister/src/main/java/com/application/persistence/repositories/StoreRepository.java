package com.application.persistence.repositories;

import com.application.persistence.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface StoreRepository extends JpaRepository<Store, Long> {
}