package com.nowak.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    Long id;

    @Column(name="cardType")
    String cardType;

    @Column(name="cardNumber")
    Long cardNumber;

    @Column(name="securityCode")
    Long securityCode;

    @Column(name="expirationDate")
    Date expirationDate;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "payment")
    Set<Purchase> purchases;

}
