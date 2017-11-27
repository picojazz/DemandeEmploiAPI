package com.picojazzemploiapi.demo.api;


import com.picojazzemploiapi.demo.dao.UserRepository;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UserRepository ur;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<Users> getAllUsers(){
        return ur.findAll();

    }
}
