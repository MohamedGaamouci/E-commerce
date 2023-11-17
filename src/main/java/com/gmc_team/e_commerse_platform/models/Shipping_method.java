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
@Table(name = "Shipping_method")
public class Shipping_method extends abstract_class{
    @Column
    private String name;

    @Column
    private BigDecimal price;


    @Column
    private Long online_shop;
    @Column
    private Long customerorder;

    @OneToMany(cascade = {CascadeType.REMOVE})
    private List<Delevery_time_detail> timeDetail;

    @Column
    private Shipping_Status status;
}
