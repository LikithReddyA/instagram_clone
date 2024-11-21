package com.thejeshlikithreddy.instagram.repository;

import com.thejeshlikithreddy.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<User, String> {
  Optional<User> getByUser(String username);

  Optional<User> getByEmailPhone(String emailOrPhone);
}
