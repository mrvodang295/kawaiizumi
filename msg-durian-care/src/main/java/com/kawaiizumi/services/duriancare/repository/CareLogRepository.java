package com.kawaiizumi.services.duriancare.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kawaiizumi.services.duriancare.model.CareLog;

public interface CareLogRepository extends MongoRepository<CareLog, String> {
    List<CareLog> findByTreeId(String treeId);
}
