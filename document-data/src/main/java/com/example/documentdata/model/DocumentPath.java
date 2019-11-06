package com.example.documentdata.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.nio.file.Path;
import java.util.stream.Stream;

@Entity
@Table(name = "document")
public class DocumentPath {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
    private String path;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPath(Stream<Path> files) {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
