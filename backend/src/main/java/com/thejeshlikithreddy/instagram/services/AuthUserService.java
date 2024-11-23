package com.thejeshlikithreddy.instagram.services;

import com.thejeshlikithreddy.instagram.model.User;
import com.thejeshlikithreddy.instagram.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {
    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepo.getByUser(username).orElseGet(()->usersRepo.getByEmailPhone(username).orElse(null));
        if (user !=null){
            return  org.springframework.security.core.userdetails.User.withUsername(user.getUser().equals(username)?username:user.getEmailPhone())
                    .password(user.getPassword())
                    .build();
        }
        return  null;
    }
}
