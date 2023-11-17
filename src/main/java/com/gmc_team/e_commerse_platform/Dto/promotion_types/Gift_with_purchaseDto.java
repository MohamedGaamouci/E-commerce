package com.gmc_team.e_commerse_platform.Dto.promotion_types;


import com.gmc_team.e_commerse_platform.models.promotion_types.Gift;
import com.gmc_team.e_commerse_platform.models.promotion_types.Gift_with_purchase;
import com.gmc_team.e_commerse_platform.models.promotion_types.num_product_condition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Gift_with_purchaseDto  extends PromotionDto{
//    it is for orders
//    This promotion offers a gift when a customer purchases a certain item.
    private String name;
    private List<num_product_conditionDto> conditionallproduct;
    private List<GiftDto> gift;

    public static Gift_with_purchaseDto fromEntity(Gift_with_purchase dto){
        if (dto == null)return null;
        else {
            List<GiftDto> list  = null;
            if (dto.getGift() != null){
                list = dto.getGift().stream()
                        .map(GiftDto::fromEntity).collect(Collectors.toList());
            }
            List<num_product_conditionDto> conditionallproduct=null;
            if (dto.getConditionallproduct()!=null){
                conditionallproduct = dto.getConditionallproduct().stream()
                        .map(num_product_conditionDto::fromEntity)
                        .collect(Collectors.toList());
            }
            return Gift_with_purchaseDto.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .onlineshopid(dto.getOnlineshopid())
                    .gift(list)
                    .conditionallproduct(conditionallproduct)
                    .name(dto.getName())
                    .build();
        }
    }
    public static Gift_with_purchase toEntity(Gift_with_purchaseDto dto){
        if (dto == null)return null;
        else {
            List<Gift> list  = null;
            if (dto.getGift() != null){
                list = dto.getGift().stream()
                        .map(GiftDto::toEntity).collect(Collectors.toList());
            }
            List<num_product_condition> conditionallproduct=null;
            if (dto.getConditionallproduct()!=null){
                conditionallproduct = dto.getConditionallproduct().stream()
                        .map(num_product_conditionDto::toEntity)
                        .collect(Collectors.toList());
            }
            return Gift_with_purchase.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .onlineshopid(dto.getOnlineshopid())
                    .gift(list)
                    .conditionallproduct(conditionallproduct)
                    .name(dto.getName())
                    .build();
        }
    }
    public PromotionDto getPromotion(Gift_with_purchaseDto dto){
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
