package com.picojazzemploiapi.demo.api;


import com.picojazzemploiapi.demo.dao.UserRepository;
import com.picojazzemploiapi.demo.dao.UserService;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestUserController {
    @Autowired
    private UserRepository ur;
    @Autowired
    private UserService us;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<Users> getAllUsers(){
        return ur.findAll();

    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Boolean register(@Valid Users user , BindingResult bindingResult){
        if(ur.findByEmail(user.getEmail()) != null || (ur.findByUsername(user.getUsername()) != null) || bindingResult.hasErrors()){
            return false;
        }
        us.saveUser(user);
        return true;
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public Boolean getRegister(){
        return true;
    }
}
