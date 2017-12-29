package com.picojazzemploiapi.demo.api;


import com.picojazzemploiapi.demo.dao.UserRepository;
import com.picojazzemploiapi.demo.dao.UserService;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
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

    @RequestMapping(value = "/api/me",method = RequestMethod.GET)
    public Long me(Principal principal){

        return ur.findByUsername(principal.getName()).getId();
    }

    @RequestMapping(value = "/logout")
    public Boolean logout(HttpServletRequest req, HttpServletResponse resp){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(req,resp,auth);
        }
        return true;
    }
}
