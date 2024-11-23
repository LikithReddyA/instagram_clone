package com.thejeshlikithreddy.instagram.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {
  @Id
  @Column(name = "username")
  @NotBlank
  private String user;
  @Column(name = "email_or_phone", unique = true)
  @NotBlank
  private String emailPhone;
  @NotBlank
  private String fullname;
  @NotBlank
  private String password;
}
