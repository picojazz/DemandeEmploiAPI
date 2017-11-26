package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Cv,Long> {
}
