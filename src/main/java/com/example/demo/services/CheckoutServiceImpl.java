package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //get cart info from dta
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        if (cartItems.isEmpty() == true) {
            String orderTrackingNumber = "Cart is Empty";
            return new PurchaseResponse(orderTrackingNumber);
        }

        else {
            //get customer info from dto
            Customer customer = purchase.getCustomer();

            //generate tracking
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            //populate the cart with ccart items

            cartItems.forEach(item -> cart.add(item));

            customer.add(cart);

            //populate the cart with custmer
            cart.setCustomer(customer);
            //save the cart to the correct respository

            cartRepository.save(cart);

            //cchange the cart status to ordered
            cart.setStatus(StatusType.ordered);

            //return the tracking #
            return new PurchaseResponse(orderTrackingNumber);

        }
    }

    private String generateOrderTrackingNumber() {

        // generate a random uuid #
        return UUID.randomUUID().toString();
    }
}
