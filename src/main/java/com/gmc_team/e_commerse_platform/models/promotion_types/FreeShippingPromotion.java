package com.gmc_team.e_commerse_platform.models.promotion_types;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Free_Shipping_Promotion")
@SuperBuilder
public class FreeShippingPromotion extends Promotion {
//    Free shipping is a popular promotion that offers customers free shipping on their orders over a certain amount.
//    Free shipping can be used to promote any type of product or service,
//    but it is especially popular for online retailers.
    @Column
    private BigDecimal minimumorderamount;  //is depending on the total price of the order
}
