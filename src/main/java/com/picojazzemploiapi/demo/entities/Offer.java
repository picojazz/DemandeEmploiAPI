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
    private int lon;
    private int lat;
    private String contract;
    private int Salary;
    private String dateCreate;
    @ManyToMany
    @JoinTable(name = "offerTags",joinColumns = {@JoinColumn(name="offerId")},inverseJoinColumns = {@JoinColumn(name="tagsId")})
    private List<Tags> tags;



    public Offer() {
    }

    public Offer(String title ,String about, String place, int lon, int lat, String contract, int salary, String dateCreate) {
        this.title = title;
        this.about = about;
        this.place = place;
        this.lon = lon;
        this.lat = lat;
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

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
