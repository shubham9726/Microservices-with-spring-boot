package com.example.studentdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "student")
@CompoundIndexes({@CompoundIndex(name = "delete_true_index", def = "{'deleted' : 1}")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends IdentityModel {

    private List<Object> documentId;
    @NotNull
    private String name;
    @NotNull
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

    public List<Object> getDocumentId() {
        return documentId;
    }

    public void setDocumentId(List<Object> documentId) {
        this.documentId = documentId;
    }
}
