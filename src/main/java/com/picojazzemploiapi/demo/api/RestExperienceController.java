package com.picojazzemploiapi.demo.api;

import com.picojazzemploiapi.demo.dao.ExperienceRepository;
import com.picojazzemploiapi.demo.entities.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestExperienceController {
    @Autowired
    private ExperienceRepository er;

    @RequestMapping(value = "/experiences", method = RequestMethod.GET)
    public List<Experience> getAllExperiences(){
        return er.findAll();
    }

    @RequestMapping(value = "/experiences/{id}",method = RequestMethod.GET)
    public Experience Experience(@PathVariable("id") long id){
        return er.findOne(id);

    }

    @RequestMapping(value = "/experiences",method = RequestMethod.POST)
    public boolean addExperience(Experience experience){
        er.save(experience);
        return true;

    }
    @RequestMapping(value = "/experiences/{id}",method = RequestMethod.PUT)
    public boolean editExperience(@PathVariable("id") long id, Experience experience){
        experience.setId(id);
        er.save(experience);
        return true;

    }
    @RequestMapping(value = "/experiences/{id}",method = RequestMethod.DELETE)
    public boolean deleteExperience(@PathVariable("id") long id){
        er.delete(id);
        return true;

    }

}
