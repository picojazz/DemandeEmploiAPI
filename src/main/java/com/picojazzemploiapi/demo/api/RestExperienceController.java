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
    public String addExperience(Experience experience,long idCV,long id){
        experience.setCv(cvr.findOne(idCV));


        if(id == -1) {

            er.save(experience);
        }else{
            experience.setId(id);
            er.save(experience);

        }
        return "{\"status\": \"ok\"}";

    }

    @RequestMapping(value = "/api/experiences/{id}",method = RequestMethod.DELETE)
    public String deleteExperience(@PathVariable("id") long id){
        er.delete(id);
        return "{\"status\": \"ok\"}";

    }

}
