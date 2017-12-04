package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.stereotype.Service;


public interface UserService {
    public void saveUser(Users user);
}
