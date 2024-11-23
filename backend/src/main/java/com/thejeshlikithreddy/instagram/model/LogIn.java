package com.thejeshlikithreddy.instagram.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LogIn {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
