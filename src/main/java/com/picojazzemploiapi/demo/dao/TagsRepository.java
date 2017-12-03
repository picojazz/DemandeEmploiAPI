package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags,Integer> {
}
