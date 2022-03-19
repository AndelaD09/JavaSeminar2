package com.application.persistence.repositories;

import com.application.persistence.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}