package com.gmc_team.e_commerse_platform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Shopping_cart")
public class Shopping_cart extends abstract_class {
    @OneToMany
    private List<Shopping_cart_item> shoppinglist;
    @ManyToOne
    private Customers customers;

    @Column
    private Long online_shop;
}
