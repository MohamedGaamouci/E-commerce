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
@Table(name = "Order_line")
public class Order_line extends abstract_class{

    @Column
    private BigDecimal qte;
    @Column
    private BigDecimal price;

    @Column
    private Long onlineshop;

    @ManyToOne
    private Product_item productitem;

    @Column
    private Long orderid;
}
