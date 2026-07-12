package com.example.lance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "cart_items")
@Getter
@Setter

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;


    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem",
    joinColumns = @JoinColumn(name = "cart_item_id"),
    inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions = new HashSet<>();

    @Column(name = "vacation_id", insertable = false, updatable = false)
    private Long vacation_id;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

}
