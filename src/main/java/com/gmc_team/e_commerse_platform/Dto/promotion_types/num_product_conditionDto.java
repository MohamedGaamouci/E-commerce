package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.num_product_condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class num_product_conditionDto {
    private Long id;
    private Long productid;
    private Integer qte;
    public static num_product_conditionDto fromEntity(num_product_condition dto){
        if (dto == null)return null;
        else {

            return num_product_conditionDto.builder()
                    .id(dto.getId())
                    .productid(dto.getProductitemid())
                    .qte(dto.getQte())
                    .build();
        }
    }
    public static num_product_condition toEntity(num_product_conditionDto dto){
        if (dto == null)return null;
        else {

            return num_product_condition.builder()
                    .id(dto.getId())
                    .productitemid(dto.getProductid())
                    .qte(dto.getQte())
                    .build();
        }
    }
}
