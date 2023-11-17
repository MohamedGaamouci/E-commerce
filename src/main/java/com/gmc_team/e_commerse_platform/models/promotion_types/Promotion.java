package com.gmc_team.e_commerse_platform.models.promotion_types;

import com.gmc_team.e_commerse_platform.models.abstract_class;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Promotion extends abstract_class {
    @Column
    private String name;
    @Column
    private String description;
    @Enumerated(EnumType.STRING)
    private Promotion_Type promotiontype;
    @Temporal(TemporalType.DATE)
    private Date startdate;

    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column
    private Long onlineshopid;

//    Percentage discounts: This is the most common type of promotion. It offers a percentage discount on the total price of an order.
//    Free shipping: This promotion offers free shipping on orders over a certain amount.
//    Buy one, get one free: This promotion offers a free item when a customer purchases another item.
//    Gift with purchase: This promotion offers a gift when a customer purchases a certain item.
//    Bundle discounts: This promotion offers a discount on a bundle of items.
//    Seasonal promotions: This promotion offers discounts on certain items during certain times of the year.
//    Loyalty programs: This promotion rewards customers for their loyalty by offering them discounts, points, or other benefits.
//    Referral programs: This promotion rewards customers for referring their friends and family to the store.
//    Flash sales: This promotion offers discounts for a limited time only.
//    Contests and giveaways: This promotion offers customers the chance to win prizes, such as discounts, gift cards, or products.
//    In addition to these general
}
