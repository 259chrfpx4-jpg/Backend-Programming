package com.example.lance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    /*@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Division> divisions; */
}
