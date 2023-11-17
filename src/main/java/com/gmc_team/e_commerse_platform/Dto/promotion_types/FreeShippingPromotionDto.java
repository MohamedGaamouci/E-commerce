package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.FreeShippingPromotion;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class FreeShippingPromotionDto  extends PromotionDto{
//    Free shipping is a popular promotion that offers customers free shipping on their orders over a certain amount.
//    Free shipping can be used to promote any type of product or service,
//    but it is especially popular for online retailers.


    private BigDecimal minimumorderamount;  //is depending on the total price of the order

    public static FreeShippingPromotionDto fromEntity(FreeShippingPromotion dto){
        if (dto == null)return null;
        else {
            return FreeShippingPromotionDto.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .onlineshopid(dto.getOnlineshopid())
                    .minimumorderamount(dto.getMinimumorderamount())
                    .build();
        }
    }
    public static FreeShippingPromotion toEntity(FreeShippingPromotionDto dto){
        if (dto == null)return null;
        else {
            return FreeShippingPromotion.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .onlineshopid(dto.getOnlineshopid())
                    .minimumorderamount(dto.getMinimumorderamount())
                    .build();
        }
    }
    public PromotionDto getPromotion(FreeShippingPromotionDto dto){
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
