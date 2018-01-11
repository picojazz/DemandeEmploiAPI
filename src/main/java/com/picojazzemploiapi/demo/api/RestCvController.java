package com.picojazzemploiapi.demo.api;

import com.picojazzemploiapi.demo.dao.CvRepository;
import com.picojazzemploiapi.demo.entities.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCvController {
    @Autowired
    private CvRepository cvr;

    @RequestMapping(value = "/api/cv/{id}",method = RequestMethod.GET)
    public Cv cv(@PathVariable("id") long id){
        return cvr.findOne(id);

    }
    @RequestMapping(value = "/api/cv/{id}",method = RequestMethod.POST)
    public String editCv(@PathVariable("id") long id, @RequestParam(defaultValue ="" ) String firstName , @RequestParam(defaultValue ="" )String lastName,
                         @RequestParam(defaultValue ="" )String  email, @RequestParam(defaultValue ="" )String adress, @RequestParam(defaultValue = "0" )int age , @RequestParam(defaultValue ="" )String tel){
        Cv cv = cvr.findOne(id);
        cv.setEmail(email);
        cv.setAdress(adress);
        cv.setFirstName(firstName);
        cv.setLastName(lastName);
        cv.setTel(tel);
        cv.setAge(age);

        cvr.save(cv);
        return "{\"status\": \"ok\"}";

    }
}
