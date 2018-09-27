package com.market.magas.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "bird_in_magaz")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirdEntityInMagaz {

    @javax.persistence.Id
    @GeneratedValue
    private long Id;
    @Column
    private String birdType;
    @Column
    private int pricePerUnit;
    @Column
    private int weight;


}
