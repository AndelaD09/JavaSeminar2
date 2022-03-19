package com.application.persistence.repositories;

import com.application.persistence.entities.Cathegory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CathegoryRepository extends JpaRepository<Cathegory, Long> {
    public Cathegory findCathegoryByName(String name);
}