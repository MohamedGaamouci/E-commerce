package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.Gift;
import com.gmc_team.e_commerse_platform.models.promotion_types.Loyalty_programs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Loyalty_programsDto  extends PromotionDto{

    //    This promotion rewards customers for their loyalty by offering them discounts,
    //    points, or other benefits.
    private Float pointsPerDollarSpent; // 1 dollar = ? point;
    private Integer redemptionRate; // the number of point that will give the reward
    private List<GiftDto> reward;
    private Long promotionDto;//contian the promotion id

    public static Loyalty_programsDto fromEntity(Loyalty_programs dto){
        if (dto == null)return null;
        else {

            List<GiftDto> list =new ArrayList<>();
            if(dto.getReward() !=null){
                list = dto.getReward().stream()
                        .map(GiftDto::fromEntity)
                        .collect(Collectors.toList());
            }
            return Loyalty_programsDto.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .pointsPerDollarSpent(dto.getPointsPerDollarSpent())
                    .redemptionRate(dto.getRedemptionRate())
                    .reward(list)
                    .promotionDto(dto.getPromotion())
                    .onlineshopid(dto.getOnlineshopid())
                    .build();
        }
    }
    public static Loyalty_programs toEntity(Loyalty_programsDto dto){
        if (dto == null)return null;
        else {
            List<Gift> list =new ArrayList<>();
            if(dto.getReward() !=null){
                list = dto.getReward().stream()
                        .map(GiftDto::toEntity)
                        .collect(Collectors.toList());
            }
            return Loyalty_programs.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .pointsPerDollarSpent(dto.getPointsPerDollarSpent())
                    .redemptionRate(dto.getRedemptionRate())
                    .reward(list)
                    .onlineshopid(dto.getOnlineshopid())
                    .build();
        }
    }
    public PromotionDto getPromotion(Loyalty_programsDto dto){
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
