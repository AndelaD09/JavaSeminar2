package com.application.api;

import com.application.persistence.entities.Product;
import com.application.persistence.repositories.CathegoryRepository;
import com.application.persistence.repositories.ProductRepository;
import com.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CathegoryRepository cathegoryRepository;

    @PostMapping("/add")
    private ResponseEntity<Product> addNewProduct(Product product){
        productService.addNewProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PostMapping("/addProduct")
    private String addProduct(BindingResult bindingResult, @Valid Product product){
        if(bindingResult.hasErrors())
            return "add-product";
        productRepository.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/addProduct")
    private String addProduct(Model model){
        model.addAttribute("list of available products:", productRepository.findAll());
        model.addAttribute("list of sorted categories:", cathegoryRepository.findAllByOrOrderByNameAsc());
        return "addProduct";
    }

    @GetMapping
    private List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/list")
    private String showProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        var product = productService.findProductByID(id);

        model.addAttribute("user", product);
        return "update-products";
    }

    @PutMapping("/update/{id}")
    private String updateProducts(Model model, @PathVariable long id, @Valid Product update, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            update.setID(id);
            return "update-products";
        }
        productRepository.save(update);
        model.addAttribute("product list updated:", productRepository.findAll());
        return "redirect:/products/index";
    }

    @PutMapping("/update/{idd}/{idp}")
    private void setDiscountToProduct(@PathVariable long idd, @PathVariable long idp){
        productService.addDiscountToProduct(idd, idp);
    }

    @PutMapping("/update/{idc}/{idp}")
    private void setCathegoryToProduct( @PathVariable long idc, @PathVariable long idp){
        productService.addCathegoryToProduct(idc, idp);
    }

    @PostMapping("/index")
    private String IndexPage(Model model, @RequestParam int numberOfElements){
        return sortAndPage(model, 1, numberOfElements, "cathegory", "asc");
    }

    @PostMapping("/sort/{page}")
    private String sortAndPage(Model model, int page, int numberOfElements, String sortBy, String sortDir){
        model.addAttribute("Categories:", cathegoryRepository.findAll());
        model.addAttribute("List of existing products:", productRepository.findAll());
        model.addAttribute("sorted by", sortBy);
        model.addAttribute("direction of sorting : asc, desc ->", sortDir);
        var paged = productService.pageAllProducts(page, numberOfElements, sortBy, sortDir);
        model.addAttribute("total elements paged", paged.getTotalElements());
        model.addAttribute("total pages:", paged.getTotalPages());
        return "list-page";
    }

    @PostMapping("/search")
    private String searchProductByName(Model model, @RequestParam String name){
        model.addAttribute("product found by name:", productService.findProductByName(name));
        model.addAttribute("name", name);
        return "redirect:/products/index";
    }

    @GetMapping("/getList")
    private List<Product> getListOfProducts(Model model){
        var categories = cathegoryRepository.findAll();
        model.addAttribute("The available categories:", categories);
        model.addAttribute("The available items:", productRepository.findAll());
        return getProducts();
    }

    @DeleteMapping("/delete/{id}")
    private String deleteHard(Model model, @PathVariable long id){
        productService.hardDeleteProduct(id);
        return "redirect:/products/index";
    }

}
