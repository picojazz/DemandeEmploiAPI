package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Cv;
import com.picojazzemploiapi.demo.entities.Offer;
import com.picojazzemploiapi.demo.entities.Role;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository ur;
    @Autowired
    private RoleRepository rr;
    @Autowired
    private OfferRepository or;
    @Autowired
    private CvRepository cvr;

    @Override
    public void saveUser(Users user) {
        Role role = rr.findByRole("user");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setActive(1);
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        cvr.save(new Cv(ur.save(user)));
    }

    @Override
    public void addFav(Long u, Long o) {
        Users user = ur.findOne(u);
        Offer offer = or.findOne(o);
        if(!verifFav(u,o)){
            user.getOffers().add(offer);
            ur.save(user);

        }


    }

    @Override
    public Boolean verifFav(Long u, Long o) {
        Users user = ur.findOne(u);
        Offer offer = or.findOne(o);
        List<Offer> ls = user.getOffers();
        for (Offer of : ls) {
            if(of.getId() == offer.getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteFav(Long u, Long o) {
        Users user = ur.findOne(u);
        Offer offer = or.findOne(o);
        if(verifFav(u,o)){

            user.getOffers().remove(offer);
            ur.save(user);

            }

    }
}
