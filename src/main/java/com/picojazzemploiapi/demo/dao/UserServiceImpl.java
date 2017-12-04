package com.picojazzemploiapi.demo.dao;

import com.picojazzemploiapi.demo.entities.Cv;
import com.picojazzemploiapi.demo.entities.Role;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private CvRepository cvr;

    @Override
    public void saveUser(Users user) {
        Role role = rr.findByRole("user");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setActive(1);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        cvr.save(new Cv(ur.save(user)));
    }
}
