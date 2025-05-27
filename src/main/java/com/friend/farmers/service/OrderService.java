package com.friend.farmers.service;


import com.friend.farmers.payload.OrderDTO;

public interface OrderService {
    OrderDTO placeOrder(String emailId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage);
}
