package com.picojazzemploiapi.demo.api;

import com.picojazzemploiapi.demo.dao.CvRepository;
import com.picojazzemploiapi.demo.entities.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCvController {
    @Autowired
    private CvRepository cvr;

    @RequestMapping(value = "/cv/{id}",method = RequestMethod.GET)
    public Cv cv(@PathVariable("id") long id){
        return cvr.findOne(id);

    }
    @RequestMapping(value = "/cv/{id}",method = RequestMethod.PUT)
    public Boolean editCv(@PathVariable("id") long id, Cv cv){
        cv.setId(id);
        cvr.save(cv);
        return true;

    }
}
