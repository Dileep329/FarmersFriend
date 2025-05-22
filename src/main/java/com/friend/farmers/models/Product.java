package com.friend.farmers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String product_name;
    private String price;
    private String quantity;
    private String description;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="category_Name")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;

}
