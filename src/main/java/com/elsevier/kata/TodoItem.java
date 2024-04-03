package com.elsevier.kata;

import java.util.Date;
import lombok.Getter;

@Getter
public class TodoItem {

  private final String name;
  private boolean completed;
  private final Date dateAdded;
  private Date lastModified;

  public TodoItem(String name) {
    this.name = name;
    this.completed = false;
    this.dateAdded = new Date();
    this.lastModified = new Date();
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
    this.lastModified = new Date();
  }

}


