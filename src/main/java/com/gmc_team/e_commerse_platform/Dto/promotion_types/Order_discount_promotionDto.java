package com.gmc_team.e_commerse_platform.Dto.promotion_types;


import com.gmc_team.e_commerse_platform.models.promotion_types.Order_discount_promotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Order_discount_promotionDto  extends PromotionDto{

//    A flash sale is a short-term sale that offers discounts on a limited selection of products or services.
//    Flash sales are typically used to generate excitement and urgency among customers,
//    and to encourage them to make impulse purchases.
    private Integer minimumitem;
    private Float discountpercentage;

    public static Order_discount_promotionDto fromEntity(Order_discount_promotion dto){
        if (dto == null)return null;
        else {

            return Order_discount_promotionDto.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .minimumitem(dto.getMinimumitem())
                    .discountpercentage(dto.getDiscountpercentage())
                    .build();
        }
    }
    public static Order_discount_promotion toEntity(Order_discount_promotionDto dto){
        if (dto == null)return null;
        else {

            return Order_discount_promotion.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .minimumitem(dto.getMinimumitem())
                    .discountpercentage(dto.getDiscountpercentage())
                    .build();
        }
    }
    public PromotionDto getPromotion(Order_discount_promotionDto dto){
        return PromotionDto.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .promotiontype(dto.getPromotiontype())
                .startdate(dto.getStartdate())
                .enddate(dto.getEnddate())
                .onlineshopid(dto.getOnlineshopid())
                .build();
    }
}
