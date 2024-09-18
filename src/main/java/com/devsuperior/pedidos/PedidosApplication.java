package com.devsuperior.pedidos;

import com.devsuperior.pedidos.entities.Order;
import com.devsuperior.pedidos.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class PedidosApplication  implements CommandLineRunner {

    private final OrderService orderService;

    public PedidosApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PedidosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Order order1 = new Order(1034, 150.00, 20.0);
        Order order2 = new Order(2282, 800.00, 10.0);
        Order order3 = new Order(1309, 95.90, 0.0);

        Locale.setDefault(Locale.US);

        show(order1);
        show(order2);
        show(order3);

    }

    private void show(Order order) {
        System.out.println(" ");
        System.out.println("Pedido código " + order.getCode());
        System.out.println("Valor total: R$ " + String.format("%.2f", orderService.total(order)));
    }
}
