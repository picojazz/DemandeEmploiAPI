package com.picojazzemploiapi.demo.api;

import com.picojazzemploiapi.demo.dao.OfferRepository;
import com.picojazzemploiapi.demo.entities.Offer;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestOfferController {

    @Autowired
    private OfferRepository or;

    @RequestMapping(value = "/api/offers",method = RequestMethod.GET)
    public List<Offer> offers(@RequestParam(name = "p",defaultValue = "") String rech){
        return or.searchOffer("%"+rech+"%");
    }

    @RequestMapping(value = "/api/offers/{id}",method = RequestMethod.GET)
    public Offer offer(@PathVariable("id") long id){
        return or.findOne(id);
    }

}
