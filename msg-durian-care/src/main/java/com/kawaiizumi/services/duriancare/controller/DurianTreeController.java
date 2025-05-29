package com.kawaiizumi.services.duriancare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawaiizumi.services.duriancare.model.DurianTree;
import com.kawaiizumi.services.duriancare.repository.DurianTreeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trees")
public class DurianTreeController {

    private final DurianTreeRepository repository;

    @PostMapping
    public DurianTree create(@RequestBody DurianTree tree) {
        return repository.save(tree);
    }

    @GetMapping
    public List<DurianTree> getAll() {
    	log.info("Func: GetAll(...) is running ... ");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public DurianTree getById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public DurianTree update(@PathVariable String id, @RequestBody DurianTree tree) {
        tree.setId(id);
        return repository.save(tree);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
