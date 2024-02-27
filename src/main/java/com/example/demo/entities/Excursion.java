package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    public Long id;


    @Column(name = "excursion_title")
    public String excursion_title;

    @Column(name = "excursion_price")
    public BigDecimal excursion_price;

    @Column(name = "image_url")
    public String image_url;

    @Column(name = "create_date")
    public Date create_date;

    @Column(name = "last_updated")
    public Date last_updated;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    public Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    public Set<CartItem> cartitems;
}
