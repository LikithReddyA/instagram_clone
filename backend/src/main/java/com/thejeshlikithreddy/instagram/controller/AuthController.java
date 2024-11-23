package com.thejeshlikithreddy.instagram.controller;

import com.thejeshlikithreddy.instagram.model.LogIn;
import com.thejeshlikithreddy.instagram.model.User;
import com.thejeshlikithreddy.instagram.services.JWTService;
import com.thejeshlikithreddy.instagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

  @Autowired
  UserService userService;

  @Autowired
  AuthenticationManager authenticationManager;

  private JWTService jwtService;

  public AuthController( JWTService jwtService){
    this.jwtService = jwtService;
  }

  @PostMapping("/register")
  public ResponseEntity<String> registration(@Validated @RequestBody User user, BindingResult result){
    if (result.hasErrors()){
      return ResponseEntity.badRequest().body(result.toString());
    }
    System.out.println(user);
    String message = userService.userRegistration(user);
    return ResponseEntity.ok(message);
  }

  @PostMapping("/login")
  public  ResponseEntity<String> logIn(@Validated @RequestBody LogIn logIn,BindingResult result){
    if (result.hasErrors()){
      return ResponseEntity.badRequest().body(result.toString());
    }
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logIn.getUserName(),logIn.getPassword()));
    }catch (BadCredentialsException e){
      return ResponseEntity.badRequest().body("Incorrect username or password!!!");
    }
    String jwtToken = jwtService.jwtTokenGenerator(logIn.getUserName());
      return ResponseEntity.ok(jwtToken);
  }

}
