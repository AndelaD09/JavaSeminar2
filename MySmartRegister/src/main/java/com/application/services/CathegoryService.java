package com.application.services;

import com.application.persistence.entities.Cathegory;
import com.application.persistence.repositories.CathegoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CathegoryService {
    @Autowired
    private CathegoryRepository cathegoryRepository;

    public Cathegory createNewCathegory(String name) {
        Cathegory cathegory = new Cathegory();
        cathegory.setName(name);
        return cathegoryRepository.save(cathegory);
    }

    public List<Cathegory> getAll(){
        return cathegoryRepository.findAll();
    }

    public Cathegory findCathegoryByName(String name){
        return cathegoryRepository.findCathegoryByName(name);
    }

    public Cathegory findCathegoryByID(long id){
        return cathegoryRepository.getById(id);
    }

    public void deleteCathegoryByID(long id){
        cathegoryRepository.deleteById(id);
    }

}
