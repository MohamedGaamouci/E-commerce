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
@Table(name = "percentage_discounts")
@SuperBuilder
public class Percentage_discounts extends Promotion {
//    Percentage discounts are the most common type of promotion.
//    They offer a percentage discount on the total price of an order.
//    Percentage discounts can be used to promote any type of product or service.
//    They can also be used to attract new customers, reward loyal customers, or boost sales during slow periods.
    @Column
    private Float discountPercentage;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> targetproductsid;

}
