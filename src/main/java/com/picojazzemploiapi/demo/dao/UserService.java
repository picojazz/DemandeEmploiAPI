package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.stereotype.Service;


public interface UserService {
    public String saveUser(Users user);
    public void addFav(Long u,Long o);
    public Boolean verifFav(Long u,Long o);
    public void deleteFav(Long u,Long o);
}
