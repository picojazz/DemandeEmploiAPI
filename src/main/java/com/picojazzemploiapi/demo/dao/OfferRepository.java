package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer,Long> {
}
