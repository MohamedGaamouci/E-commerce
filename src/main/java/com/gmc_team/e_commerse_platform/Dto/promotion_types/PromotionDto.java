package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.Promotion_Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class PromotionDto {
    private Long id;
    private String name;
    private String description;
    private Promotion_Type promotiontype;
    private Date startdate;

    private Date enddate;
    private Long onlineshopid;

//    Percentage discounts: This is the most common type of promotion. It offers a percentage discount on the total price of an order.
//    Free shipping: This promotion offers free shipping on orders over a certain amount.
//    Buy one, get one free: This promotion offers a free item when a customer purchases another item.
//    Gift with purchase: This promotion offers a free gift when a customer purchases a certain item.
//    Bundle discounts: This promotion offers a discount on a bundle of items.
//    Seasonal promotions: This promotion offers discounts on certain items during certain times of the year.
//    Loyalty programs: This promotion rewards customers for their loyalty by offering them discounts, points, or other benefits.
//    Referral programs: This promotion rewards customers for referring their friends and family to the store.
//    Flash sales: This promotion offers discounts for a limited time only.
//    Contests and giveaways: This promotion offers customers the chance to win prizes, such as discounts, gift cards, or products.
//    In addition to these general
}
