package com.devsuperior.pedidos.services;

import com.devsuperior.pedidos.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        return ((order.getBasic() - discount(order)) + shipping(order));
    }

    private double discount(Order order) {
        return (order.getBasic() * (order.getDiscount() / 100));
    }

    private double shipping(Order order) {
        if (order.getBasic() < 100) {
            return 20.00;
        } else if ((order.getBasic() >= 100) && (order.getBasic() <= 200)) {
            return 12.00;
        }
        return 0;
    }

}
