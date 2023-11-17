package com.gmc_team.e_commerse_platform.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "shopping_cart_item")
public class Shopping_cart_item extends abstract_class{
    @ManyToOne
    private Product_item product_item;
    @Column
    private BigDecimal qte;
    @Column
    private Long online_shop;

}
