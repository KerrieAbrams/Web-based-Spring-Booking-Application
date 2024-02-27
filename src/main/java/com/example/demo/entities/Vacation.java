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
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "vacation_description")
    private String description;

    @Column(name = "travel_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "created_date")
    private Date create_date;

    @Column(name = "last_updated")
    private Date last_updated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions;

}
