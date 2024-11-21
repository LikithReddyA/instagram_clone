package com.thejeshlikithreddy.instagram.services;

import com.thejeshlikithreddy.instagram.model.User;
import com.thejeshlikithreddy.instagram.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
  @Autowired
  private UsersRepo usersRepo;

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
