package com.nowak.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "shipping")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    Long id;

    @Column(name = "postalCode")
    String postalCode;

    @Column(name = "country")
    String country;

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "building")
    String building;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "shipping")
    Set<Purchase> purchases;
}
