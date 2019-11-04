package com.example.documentdata.model;

import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = "student")
public class Document {

    private List<Object> document;
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Object> getDocument() {
        return document;
    }

    public void setDocument(List<Object> document) {
        this.document = document;
    }
}
