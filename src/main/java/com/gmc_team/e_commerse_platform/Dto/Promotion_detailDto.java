package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Promotion_detail;
import com.gmc_team.e_commerse_platform.models.promotion_types.Promotion_Type;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Promotion_detailDto {
    private Long id;
    private Promotion_Type type;
    private Long promotion;
    public static Promotion_detailDto fromEntity(Promotion_detail dto){
        if (dto == null)return null;
        else{
            return Promotion_detailDto.builder()
                    .id(dto.getId())
                    .promotion(dto.getPromotion())
                    .type(dto.getType())
                    .build();
        }
    }
    public static Promotion_detail toEntity(Promotion_detailDto dto){
        if (dto == null)return null;
        else{
            return Promotion_detail.builder()
                    .id(dto.getId())
                    .promotion(dto.getPromotion())
                    .type(dto.getType())
                    .build();
        }
    }
}
