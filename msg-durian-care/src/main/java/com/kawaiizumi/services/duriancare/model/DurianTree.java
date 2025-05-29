package com.kawaiizumi.services.duriancare.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "durian_trees")
public class DurianTree {
    @Id
    private String id;
    private String treeId;
    private String variety;
    private String location;
    private LocalDate plantedDate;
    private String status;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTreeId() { return treeId; }
    public void setTreeId(String treeId) { this.treeId = treeId; }
    public String getVariety() { return variety; }
    public void setVariety(String variety) { this.variety = variety; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public LocalDate getPlantedDate() { return plantedDate; }
    public void setPlantedDate(LocalDate plantedDate) { this.plantedDate = plantedDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
