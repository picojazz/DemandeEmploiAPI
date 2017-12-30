package com.picojazzemploiapi.demo.dao;


import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users,Long>{
    public Users findByUsername(String username);
    public Users findByEmail(String email);
    @Query("select u from Users u where u.username = :x and u.password = :y")
    public Users connect(@Param("x") String username,@Param("y")String password);
}
