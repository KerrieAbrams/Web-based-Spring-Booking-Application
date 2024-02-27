package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public Long id;

    @Column(name = "customer_first_name")
    public String firstName;

    @Column(name = "customer_last_name")
    public String lastName;

    @Column(name = "address")
    public String address;

    @Column(name = "postal_code")
    public String postal_code;

    @Column(name = "phone")
    public String phone;

    @Column(name = "create_date")
    public Date create_date;

    @Column(name = "last_update")
    public Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    public Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    public Set<Cart> carts;
}
