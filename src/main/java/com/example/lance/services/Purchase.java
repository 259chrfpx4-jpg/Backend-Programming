package com.example.lance.services;

import com.example.lance.entities.Cart;
import com.example.lance.entities.CartItem;
import com.example.lance.entities.Customer;
import java.util.Set;

import lombok.Data;

import jakarta.validation.constraints.*;

@Data

public class Purchase {
    @NotNull(message = "Customer information is required")
    private Customer customer;

    @NotNull(message = "Cart is required")
    private Cart cart;

    @NotNull(message = "Your cart is empty")
    private Set<CartItem> cartItems;
}
