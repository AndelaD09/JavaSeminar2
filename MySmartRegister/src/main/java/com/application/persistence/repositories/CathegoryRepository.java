package com.application.persistence.repositories;

import com.application.persistence.entities.Cathegory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Component
public interface CathegoryRepository extends JpaRepository<Cathegory, Long> {
    Cathegory findCathegoryByName(String name);
}