package com.project.jee.spautiflop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestDataObject {

  @Id
  private long id;

  @Column
  private String usernaaaame;
}
