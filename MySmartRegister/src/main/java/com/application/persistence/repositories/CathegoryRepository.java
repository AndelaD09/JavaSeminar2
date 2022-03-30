package com.application.persistence.repositories;

import com.application.persistence.entities.Cathegory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public interface CathegoryRepository extends JpaRepository<Cathegory, Long>, PagingAndSortingRepository<Cathegory, Long> {
    Cathegory findCathegoryByName(String name);
    ArrayList<Cathegory> findAllByOrOrderByNameAsc();
    ArrayList<Cathegory> findAllByOrOrderByNameDesc();
}