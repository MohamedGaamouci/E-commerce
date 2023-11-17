package com.gmc_team.e_commerse_platform.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Customer_order")
public class Order extends abstract_class{

    @Enumerated(EnumType.STRING)
    private Order_status orderstatus;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private Shipping_method shippingMethod;
    @Column
    private Long customerid ;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private Payment_method paymentmethod;
    @Column
    private BigDecimal fullprice;
    @ManyToOne
    private Address shippingaddress;

    @OneToMany
    @JsonManagedReference
    private List<Order_line> orderlines;

    @OneToOne
    private Order_review review;
    @Column
    private Long onlineshop;

}
