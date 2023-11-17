package com.gmc_team.e_commerse_platform.models.promotion_types;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Gift_with_purchase")
@SuperBuilder
public class Gift_with_purchase extends Promotion {//it is for orders
//    This promotion offers a gift when a customer purchases a certain item.

    @Column
    private String name;
    @OneToMany
    private List<num_product_condition> conditionallproduct; //condition num of product ,product id

    @ManyToMany
    private List<Gift> gift;


}
