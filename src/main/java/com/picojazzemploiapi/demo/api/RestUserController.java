package com.picojazzemploiapi.demo.api;


import com.picojazzemploiapi.demo.dao.UserRepository;
import com.picojazzemploiapi.demo.dao.UserService;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestUserController {
    @Autowired
    private UserRepository ur;
    @Autowired
    private UserService us;


    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public List<Users> getAllUsers(){
        return ur.findAll();

    }
    @RequestMapping(value = "/api/users/{id}",method = RequestMethod.GET)
    public Users getAllUsers(@PathVariable("id") long id){
        return ur.findOne(id);

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
    public String me(@RequestParam(name = "username") String username , @RequestParam(name = "password")String password){


        Users user = ur.connect(username,password);
        if(user != null){
            return "{\"status\": \"ok\",\"id\": \""+user.getId()+"\"}";
        }else{
            return "{\"status\": \"ko\"}";
        }

    }
    @RequestMapping(value = "/api/add-fav", method=RequestMethod.GET)
    public void addFav(@RequestParam(name = "idU")Long idUser,@RequestParam(name = "idO")Long idOffer){
        us.addFav(idUser,idOffer);
    }
    @RequestMapping(value = "/api/verif-fav", method=RequestMethod.GET)
    public String verifFav(@RequestParam(name = "idU")Long idUser,@RequestParam(name = "idO")Long idOffer){
       if(us.verifFav(idUser,idOffer)){
           return "{\"status\": \"ok\"}";
       }
        return "{\"status\": \"ko\"}";
    }
    @RequestMapping(value = "/api/delete-fav", method=RequestMethod.GET)
    public void deleteFav(@RequestParam(name = "idU")Long idUser,@RequestParam(name = "idO")Long idOffer){
        us.deleteFav(idUser,idOffer);

    }


}
