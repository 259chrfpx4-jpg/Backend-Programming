package com.example.lance.services;

import com.example.lance.dao.CartItemRepository;
import com.example.lance.dao.CartRepository;
import com.example.lance.dao.CustomerRepository;
import com.example.lance.entities.Cart;
import com.example.lance.entities.CartItem;
import com.example.lance.entities.Customer;
import com.example.lance.entities.StatusType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;

    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();

        //debug looking for tracking number
        System.out.println("TRACKING #######: " + orderTrackingNumber);

        cart.setOrderTrackingNumber(orderTrackingNumber);

        cart.setStatus(StatusType.ordered);

        Customer customer = purchase.getCustomer();

        Set<CartItem> cartItems = purchase.getCartItems();

        if (cartItems != null) {
            cartItems.forEach(item -> {
                cart.add(item);

                item.setCart(cart);
            });
        }

        customer.add(cart);

        cart.setCustomer(customer);

        customerRepository.save(customer);
        //cartRepository.save(cart); maybe this is the problem

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}