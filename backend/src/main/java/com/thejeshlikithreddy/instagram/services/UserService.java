package com.thejeshlikithreddy.instagram.services;

import com.thejeshlikithreddy.instagram.model.User;
import com.thejeshlikithreddy.instagram.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UsersRepo usersRepo;

  public String userRegistration(User user){
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    User existingUser = usersRepo.getByUser(user.getUser()).orElseGet(()->usersRepo.getByEmailPhone(user.getEmailPhone()).orElse(null));
    if (existingUser != null){
      return "User already exists!!!";
    }
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    usersRepo.save(user);
    return "User registered successfully!!!";
  }

  public List<User> getUsers() {
    return usersRepo.findAll();
  }

  public Optional<User> getUserById(String username) {
    return usersRepo.getByUser(username);
  }

  public Optional<User> getUserByEmailOrPhone(String emailOrPhone) {
    return usersRepo.getByEmailPhone(emailOrPhone);
  }
}
