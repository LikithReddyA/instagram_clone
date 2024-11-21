package com.thejeshlikithreddy.instagram.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {
  @Id
  @Column(name = "username")
  private String user;
  @Column(name = "email_or_phone", unique = true)
  private String emailPhone;
  private String fullname;
  private String password;
}
