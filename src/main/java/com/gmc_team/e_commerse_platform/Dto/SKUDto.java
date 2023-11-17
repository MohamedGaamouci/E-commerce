package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.SKU;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SKUDto {
    private Long Id;
    private String Name;
    private Long onlineshop;

    public static SKU toEntity(SKUDto dto){
        SKU sku =new SKU();
        sku.setId(dto.getId());
        sku.setName(dto.getName().trim());
        sku.setOnlineshop((dto.getOnlineshop()));

        return sku;
    }
    public static SKUDto fromEntity(SKU sku){
        return SKUDto.builder()
                .Id(sku.getId())
                .Name(sku.getName())
                .onlineshop(sku.getOnlineshop())
                .build();
    }
}
