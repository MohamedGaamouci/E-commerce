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
@Table(name = "Order_review")
public class Order_review extends abstract_class{
    @Column
    private Long customerid;

    @Column
    private Long customerorder;

    @Column
    private Integer rating;
    @Column
    private String comment;

    @Column
    private Long onlineshop;

}
