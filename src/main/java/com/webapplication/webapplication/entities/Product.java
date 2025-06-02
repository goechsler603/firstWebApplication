package com.webapplication.webapplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table (name = "tb_product")
public class Product implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @Builder.Default
    @Getter
    @ManyToMany
    @JoinTable(name = "tb_product_category",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @JsonIgnore
    public Set<Order>  getOrders() {
        Set<Order> listOrders = new HashSet<>();
        for (OrderItem orderItem : items) {
            listOrders.add(orderItem.getOrder());
        }
        return listOrders;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


