package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    public Long id;

    @Column(name = "vacation_title")
    public String vacation_title;

    @Column(name = "vacation_description")
    public String description;

    @Column(name = "travel_price")
    public BigDecimal travel_price;

    @Column(name = "image_url")
    public String image_url;

    @Column(name = "created_date")
    public Date create_date;

    @Column(name = "last_updated")
    public Date last_updated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    public Set<Excursion> excursions;

}
