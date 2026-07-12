package com.example.lance.controllers;

import com.example.lance.services.CheckoutService;
import com.example.lance.services.Purchase;
import com.example.lance.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        return checkoutService.placeOrder(purchase);
    }
}
