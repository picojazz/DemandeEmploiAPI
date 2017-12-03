package com.picojazzemploiapi.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tags {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Offer> offers;

}
