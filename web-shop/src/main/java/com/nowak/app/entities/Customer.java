package com.nowak.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "customer")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    Long id;

    @Column(name="firstName")
    String firstName;

    @Column(name="lastName")
    String lastName;

    @Column(name="email")
    String email;

    @Column(name="phoneNumber")
    String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "customer")
    Set<Purchase> purchases;
}
