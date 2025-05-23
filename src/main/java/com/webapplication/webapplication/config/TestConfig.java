package com.webapplication.webapplication.config;

import com.webapplication.webapplication.entities.Category;
import com.webapplication.webapplication.entities.Order;
import com.webapplication.webapplication.entities.Product;
import com.webapplication.webapplication.entities.User;
import com.webapplication.webapplication.entities.enums.OrderStatus;
import com.webapplication.webapplication.repositories.CategoryRepository;
import com.webapplication.webapplication.repositories.OrderRepository;
import com.webapplication.webapplication.repositories.ProductRepository;
import com.webapplication.webapplication.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2025-03-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2025-04-21T03:42:10Z"),OrderStatus.CANCELLED, u2);
        Order o3 = new Order(null, Instant.parse("2025-05-22T15:21:22Z"),OrderStatus.SHIPPED, u1);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        Category cat1 = Category.builder()
                .id(null)
                .name("Eletronics")
                .build();
        Category cat2 = Category.builder()
                .id(null)
                .name("Books")
                .build();
        Category cat3 =Category.builder()
                .id(null)
                .name("Computers")
                .build();

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = Product.builder()
                .id(null)
                .name("Smartphone")
                .description("S21")
                .price(43.)
                .imgUrl("")
                .build();
        Product p2 = Product.builder()
                .id(null)
                .name("Notebook Asus")
                .description("I7 sem placa de video 16gb RAM")
                .price(40.)
                .imgUrl("")
                .build();
        Product p3 = Product.builder()
                .id(null)
                .name("One piece")
                .description("O melhor de todos")
                .price(50.)
                .imgUrl("")
                .build();

        productRepository.saveAll(Arrays.asList(p1,p2,p3));

    }
}
