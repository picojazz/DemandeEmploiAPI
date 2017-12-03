package com.picojazzemploiapi.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Offer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String about;
    private String place;
    private String contract;
    private int Salary;
    private Date dateCreate;
    @ManyToMany
    @JoinTable(name = "offerTags",joinColumns = {@JoinColumn(name="offerId")},inverseJoinColumns = {@JoinColumn(name="tagsId")})
    private List<Tags> tags;



    public Offer() {
    }

    public Offer(String title, String about, String place, String contract, int salary, Date dateCreate) {
        this.title = title;
        this.about = about;
        this.place = place;
        this.contract = contract;
        Salary = salary;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
