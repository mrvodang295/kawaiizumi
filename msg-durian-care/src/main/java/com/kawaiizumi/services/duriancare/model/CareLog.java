package com.kawaiizumi.services.duriancare.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "care_logs")
public class CareLog {
    @Id
    private String id;
    private String treeId;
    private LocalDate date;
    private String action;
    private String note;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTreeId() { return treeId; }
    public void setTreeId(String treeId) { this.treeId = treeId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
