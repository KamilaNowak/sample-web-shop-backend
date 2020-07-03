package com.nowak.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="item_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="category_title")
    private String category;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "category"
    )
    private Set<Item> itemList;
}
