package com.application.api;

import com.application.persistence.entities.Cathegory;
import com.application.persistence.repositories.CathegoryRepository;
import com.application.services.CathegoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/category")
public class CathegoryController {
    @Autowired
    private CathegoryRepository cathegoryRepository;
    @Autowired
    private CathegoryService cathegoryService;

    @GetMapping("/add")
    private String createModelCathegory(Model model){
        model.addAttribute("new cathegory:", new Cathegory());
        return "createCathegory";
    }

    @PostMapping("/add")
    private RedirectView createCategory (String name){
        var cathegory = cathegoryService.createNewCathegory(name);
        return new RedirectView("/category/add");
    }

    @GetMapping("/find/{name}")
    private Cathegory findCathegoryByName(@PathVariable String name){
        return cathegoryService.findCathegoryByName(name);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteCathegoryByID(@PathVariable long id){
        cathegoryService.deleteCathegoryByID(id);
    }
}
