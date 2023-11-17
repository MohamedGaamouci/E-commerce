package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.TieredPromotion;
import com.gmc_team.e_commerse_platform.models.promotion_types.TieredPromotionItem;
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
public class TieredPromotionDto extends PromotionDto{
    private List<TieredPromotionItemDto> tiers;
    //condition price -- the reward (percentage discount promotion)


    public static TieredPromotionDto fromEntity(TieredPromotion dto){
        if (dto == null)return null;
        else {
            List<TieredPromotionItemDto> list = null;
            if(dto.getTiers() != null){
                list= dto.getTiers().stream()
                        .map(TieredPromotionItemDto::fromEntity).collect(Collectors.toList());
            }
            return TieredPromotionDto.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .tiers(list)
                    .build();
        }
    }
    public static TieredPromotion toEntity(TieredPromotionDto dto){
        if (dto == null)return null;
        else {
            List<TieredPromotionItem> list = null;
            if(dto.getTiers() != null){
                list= dto.getTiers().stream()
                        .map(TieredPromotionItemDto::toEntity).collect(Collectors.toList());
            }
            return TieredPromotion.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .tiers(list)
                    .build();
        }
    }
    public PromotionDto getPromotion(TieredPromotionDto dto){
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
