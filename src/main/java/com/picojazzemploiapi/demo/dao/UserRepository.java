package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
}
