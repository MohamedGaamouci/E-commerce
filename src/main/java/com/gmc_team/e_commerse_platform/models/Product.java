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
@Table(name = "Product")
public class Product extends abstract_class {

    @Column
    private String name;

    @ManyToOne
    private SKU sku;
    @Column
    private BigDecimal price;
    @OneToMany(cascade = {CascadeType.REMOVE})
    private List<Descriptions> descriptions;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "productvariation")
    private List<Product_item> productitems;


    @ManyToMany(cascade = {CascadeType.REMOVE})
    private List<Images> images;
    @OneToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.REMOVE})
    private List<Product_review> Product_review ;
    @Column
    private Long onlineshop;

    @ManyToOne
    private Promotion_detail promotion;
    @Column
    private Integer minimumorderqte;

}
