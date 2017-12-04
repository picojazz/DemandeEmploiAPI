package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Integer>{

    public Role findByRole(String role);
}
