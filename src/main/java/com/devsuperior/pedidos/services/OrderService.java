package com.devsuperior.pedidos.services;

import com.devsuperior.pedidos.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        return this.shippingService.shipment(order);
    }

}
