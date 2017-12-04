package com.picojazzemploiapi.demo.api;

import com.picojazzemploiapi.demo.dao.CvRepository;
import com.picojazzemploiapi.demo.dao.FormationRepository;
import com.picojazzemploiapi.demo.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestFormationController {
    @Autowired
    private FormationRepository fr;
    @Autowired
    private CvRepository cvr;

    @RequestMapping(value = "/api/formations", method = RequestMethod.GET)
    public List<Formation> getAllFormations(){
        return fr.findAll();
    }
    @RequestMapping(value = "/api/formations/{id}",method = RequestMethod.GET)
    public Formation Formation(@PathVariable("id") long id){
        return fr.findOne(id);

    }
    @RequestMapping(value = "/api/formations",method = RequestMethod.POST)
    public boolean addFormation(Formation formation,long idCV){
        formation.setCv(cvr.findOne(idCV));
        fr.save(formation);
        return true;

    }
    @RequestMapping(value = "/api/formations/{id}",method = RequestMethod.PUT)
    public boolean editFormation(@PathVariable("id") long id, Formation formation,long idCV){
        formation.setId(id);
        formation.setCv(cvr.findOne(idCV));
        fr.save(formation);
        return true;

    }
    @RequestMapping(value = "/api/formations/{id}",method = RequestMethod.DELETE)
    public boolean deleteFormation(@PathVariable("id") long id){
        fr.delete(id);
        return true;

    }
}
