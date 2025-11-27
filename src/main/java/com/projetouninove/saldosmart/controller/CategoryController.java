package com.projetouninove.saldosmart.controller;

import com.projetouninove.saldosmart.infrastructure.entity.Category;
import com.projetouninove.saldosmart.infrastructure.repository.CategoryRepository;
import com.projetouninove.saldosmart.business.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@Slf4j
public class CategoryController {

    @Autowired // Injection of dependency
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> index() {
        return categoryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody @Valid Category category){
        log.info("criando categoria " + category);
        return categoryService.save(category);
    }

    @GetMapping("{id}") // chaves indica que o id é uma variável
    public Category get(@PathVariable Long id) {
        log.info("buscando categoria com id " + id);
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando categoria com id {}", id);
        categoryService.deleteById(id);
    }

    @PutMapping("{id}")
    public Category update(@RequestBody @Valid Category categoryUpdated, @PathVariable Long id) {
        log.info("atualizando categoria {} com id {}", categoryUpdated, id);
        return categoryService.update(categoryUpdated, id);
    }
}
