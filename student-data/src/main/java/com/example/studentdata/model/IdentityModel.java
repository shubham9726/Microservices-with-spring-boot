package com.example.studentdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityModel implements Serializable {
  @Indexed(direction = IndexDirection.DESCENDING)
  private long createdAt;
  @Indexed(direction = IndexDirection.DESCENDING)
  private long updatedAt;
  @Indexed(direction = IndexDirection.DESCENDING)
  private long deletedAt;
  @Id
  private String id;
  private boolean deleted = false;

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(long updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(long deletedAt) {
    this.deletedAt = deletedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
  }
