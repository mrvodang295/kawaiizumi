package com.kawaiizumi.services.duriancare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kawaiizumi.services.duriancare.model.DurianTree;

public interface DurianTreeRepository extends MongoRepository<DurianTree, String> {
    DurianTree findByTreeId(String treeId);
}
