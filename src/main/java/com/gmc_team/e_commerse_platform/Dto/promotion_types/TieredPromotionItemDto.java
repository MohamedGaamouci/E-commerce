package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.TieredPromotionItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TieredPromotionItemDto {
    private Long id;
    private BigDecimal conditionnal_price;
    private Long promotionid;
    public static TieredPromotionItemDto fromEntity(TieredPromotionItem dto){
        if (dto == null) return null;
        else {
            return TieredPromotionItemDto.builder()
                    .id(dto.getId())
                    .conditionnal_price(dto.getPrice())
                    .promotionid(dto.getPromotionid())
                    .build();
        }
    }
    public static TieredPromotionItem toEntity(TieredPromotionItemDto dto){
        if (dto == null) return null;
        else {
            return TieredPromotionItem.builder()
                    .id(dto.getId())
                    .price(dto.getConditionnal_price())
                    .promotionid(dto.getPromotionid())
                    .build();
        }
    }
}
