package com.gmc_team.e_commerse_platform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Product_item")
public class Product_item extends abstract_class{

    @Column(name = "root_product")
    private Long product;
    @Column
    private BigDecimal qte;
    @Column
    private BigDecimal price ;

    @OneToMany(fetch = FetchType.EAGER ,cascade = {CascadeType.REMOVE})
    private List<Images> images;

    @ManyToMany
    private List<Variation> variations;
    @Column
    private Long online_shop;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Variation_option> variation_option;






}
