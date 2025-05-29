package com.kawaiizumi.services.duriancare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kawaiizumi.services.duriancare.model.DurianTree;
import com.kawaiizumi.services.duriancare.repository.DurianTreeRepository;

@RestController
@CrossOrigin(origins = "https://durian-care.onrender.com")
@RequestMapping("/api/trees")
public class DurianTreeController {

    @Autowired
    private DurianTreeRepository repository;

    @PostMapping
    public DurianTree create(@RequestBody DurianTree tree) {
        return repository.save(tree);
    }

    @GetMapping
    public List<DurianTree> getAll() {
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
