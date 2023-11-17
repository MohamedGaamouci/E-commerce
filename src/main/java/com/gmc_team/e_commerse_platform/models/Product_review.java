package com.gmc_team.e_commerse_platform.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Product_review")
public class Product_review extends abstract_class{

    @Column
    private Integer rating;

    @Column
    private String comment;
    @Column
    private Long onlineshop;


    @Column
    private Long product;

    @Column
    private Long customerid;
}
