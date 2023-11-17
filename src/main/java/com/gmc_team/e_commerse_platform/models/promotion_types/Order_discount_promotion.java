package com.gmc_team.e_commerse_platform.models.promotion_types;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Order_discount_promotion")
@SuperBuilder
public class Order_discount_promotion extends Promotion {
//    A flash sale is a short-term sale that offers discounts on a limited selection of products or services.
//    Flash sales are typically used to generate excitement and urgency among customers,
//    and to encourage them to make impulse purchases.
    @Column
    private Integer minimumitem;
    @Column
    private Float discountpercentage;
}
