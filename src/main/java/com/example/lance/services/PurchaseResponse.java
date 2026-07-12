package com.example.lance.services;

import lombok.Data;

@Data

public class PurchaseResponse {
    private final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
