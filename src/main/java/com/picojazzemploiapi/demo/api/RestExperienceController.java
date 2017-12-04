package com.picojazzemploiapi.demo.api;

import com.picojazzemploiapi.demo.dao.CvRepository;
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
    @Autowired
    private CvRepository cvr;

    @RequestMapping(value = "/api/experiences", method = RequestMethod.GET)
    public List<Experience> getAllExperiences(){
        return er.findAll();
    }

    @RequestMapping(value = "/api/experiences/{id}",method = RequestMethod.GET)
    public Experience Experience(@PathVariable("id") long id){
        return er.findOne(id);

    }

    @RequestMapping(value = "/api/experiences",method = RequestMethod.POST)
    public boolean addExperience(Experience experience,long idCV){
        experience.setCv(cvr.findOne(idCV));
        er.save(experience);
        return true;

    }
    @RequestMapping(value = "/api/experiences/{id}",method = RequestMethod.PUT)
    public boolean editExperience(@PathVariable("id") long id, Experience experience,long idCV){
        experience.setId(id);
        experience.setCv(cvr.findOne(idCV));
        er.save(experience);
        return true;

    }
    @RequestMapping(value = "/api/experiences/{id}",method = RequestMethod.DELETE)
    public boolean deleteExperience(@PathVariable("id") long id){
        er.delete(id);
        return true;

    }

}
