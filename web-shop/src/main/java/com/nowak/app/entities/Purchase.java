package com.nowak.app.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "purchase")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    String id;

    @Column(name="serialNumber")
    String serialNumber;

    @Column(name="title")
    String title;

    @Column(name="price")
    double price;

    @Column(name="imageUrl")
    String imageUrl;

    @Column(name="quantity")
    int quantity;

    @ManyToOne()
    @JoinColumn(nullable = false,
                name="customer_id")
    Customer customer;

    @ManyToOne()
    @JoinColumn(nullable = false,
                name="shipping_id")
    Shipping shipping;

    @ManyToOne()
    @JoinColumn(nullable = false,
                name="payment_id")
    Payment payment;

}
