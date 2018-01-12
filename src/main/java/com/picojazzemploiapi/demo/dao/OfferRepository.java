package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer,Long> {
    @Query("select o from Offer o where o.title like :x Or o.place like :x Or o.contract like :x Or o.company like :x order by o.dateCreate desc ")
    public List<Offer> searchOffer(@Param("x") String rech);


}
