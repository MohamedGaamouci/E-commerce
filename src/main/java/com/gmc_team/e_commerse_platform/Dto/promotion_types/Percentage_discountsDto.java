package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.Percentage_discounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Percentage_discountsDto  extends PromotionDto {


    //    Percentage discounts are the most common type of promotion.
//    They offer a percentage discount on the total price of an order.
//    Percentage discounts can be used to promote any type of product or service.
//    They can also be used to attract new customers, reward loyal customers, or boost sales during slow periods.
    private List<Long> targetproductsid;
    private Float discountPercentage;

    public static Percentage_discountsDto fromEntity(Percentage_discounts dto){
        if (dto == null)return null;
        else {

            return Percentage_discountsDto.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .onlineshopid(dto.getOnlineshopid())
                    .targetproductsid(dto.getTargetproductsid())
                    .discountPercentage(dto.getDiscountPercentage())
                    .build();
        }
    }
    public static Percentage_discounts toEntity(Percentage_discountsDto dto){
        if (dto == null)return null;
        else {

            return Percentage_discounts.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .onlineshopid(dto.getOnlineshopid())
                    .targetproductsid(dto.getTargetproductsid())
                    .discountPercentage(dto.getDiscountPercentage())
                    .build();
        }
    }
    public PromotionDto getPromotion(Percentage_discountsDto dto){
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
