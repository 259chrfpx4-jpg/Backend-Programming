package com.example.lance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "customers")
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotEmpty(message = "First name is required")
    @Size(max = 50, message = "First name cannot be more than 50 characters")
    @Column(name = "customer_first_name")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Size(max = 50, message = "Lance name cannot be more than 50 characters")
    @Column(name = "customer_last_name")
    private String lastName;

    @NotEmpty(message = "Address name is required")
    @Size(max = 50, message = "Address cannot be more than 50 characters")
    @Column(name = "address")
    private String address;

    @NotEmpty(message = "Postal code is required")
    @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$", message = "Invalid postal code")
    @Column(name = "postal_code")
    private String postal_code;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^\\([0-9]{3}\\)[0-9]{3}-[0-9]{4}$", message = "Invalid phone number")
    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "division_id", nullable = false)
    private Long division_id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
        carts.add(cart);
        cart.setCustomer(this);
    }

}
