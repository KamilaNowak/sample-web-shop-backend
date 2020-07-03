package com.nowak.app.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="serial_number")
    private String serialNumber;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Long price;

    @Column(name="availability")
    private int availability;

    @Column(name="image_url")
    private String imageUrl;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="last_updated_at")
    private Date lastUpdatedAt;

    @ManyToOne()
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private ItemCategory itemCategory;



}
