package com.picojazzemploiapi.demo.api;

import com.picojazzemploiapi.demo.dao.OfferRepository;
import com.picojazzemploiapi.demo.entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestOfferController {

    @Autowired
    private OfferRepository or;

    @RequestMapping(value = "/api/offers",method = RequestMethod.GET)
    public List<Offer> offers(){
        return or.findAll();
    }

    @RequestMapping(value = "/api/offers/{id}",method = RequestMethod.GET)
    public Offer offer(@PathVariable("id") long id){
        return or.findOne(id);
    }

}
