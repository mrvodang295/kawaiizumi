package com.kawaiizumi.services.duriancare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kawaiizumi.services.duriancare.model.CareLog;
import com.kawaiizumi.services.duriancare.repository.CareLogRepository;

@RestController
@RequestMapping("/api/care-logs")
public class CareLogController {

    @Autowired
    private CareLogRepository repository;

    @PostMapping
    public CareLog create(@RequestBody CareLog log) {
        return repository.save(log);
    }

    @GetMapping("/tree/{treeId}")
    public List<CareLog> getByTree(@PathVariable String treeId) {
        return repository.findByTreeId(treeId);
    }

    @GetMapping
    public List<CareLog> getAll() {
        return repository.findAll();
    }
}
