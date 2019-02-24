package com.example.shop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private float price;

}
