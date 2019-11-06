package com.example.documentdata.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = "document")
public class Document {

    @Id
    private String id;
    @NotNull
    private List<Object> document;
    @NotNull
    private String name;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getDocument() {
        return document;
    }

    public void setDocument(List<Object> document) {
        this.document = document;
    }
}
