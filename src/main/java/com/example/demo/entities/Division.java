package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    public Long id;

    @Column(name = "division")
    public String division_name;

    @Column(name = "create_date")
    public Date create_date;

    @Column(name = "last_updated")
    public Date last_updated;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    public Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    public Set<Customer> customers;
}
