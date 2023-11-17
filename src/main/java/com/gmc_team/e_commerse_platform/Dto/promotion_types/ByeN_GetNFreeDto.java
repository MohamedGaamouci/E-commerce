package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.ByeN_GetNFree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ByeN_GetNFreeDto  extends PromotionDto{
    private Integer productshouldbye;
    private Integer freeproductwillget;
    private List<Long> targetproduct;



    public static ByeN_GetNFreeDto fromEntity(ByeN_GetNFree dto){
        if (dto == null)return null;
        else{
            return ByeN_GetNFreeDto.builder()
                    .id(dto.getId())
                    .description(dto.getDescription())
                    .name(dto.getName())
                    .promotiontype(dto.getPromotiontype())
                    .startdate(dto.getStartdate())
                    .enddate(dto.getEnddate())
                    .onlineshopid(dto.getOnlineshopid())
                    .productshouldbye(dto.getProductshouldbye())
                    .freeproductwillget(dto.getFreeproductwillget())
                    .targetproduct(dto.getTargetproduct())
                    .build();
        }
    }
    public static ByeN_GetNFree toEntity(ByeN_GetNFreeDto dto){
        return ByeN_GetNFree.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .name(dto.getName())
                .promotiontype(dto.getPromotiontype())
                .startdate(dto.getStartdate())
                .enddate(dto.getEnddate())
                .onlineshopid(dto.getOnlineshopid())
                .productshouldbye(dto.getProductshouldbye())
                .freeproductwillget(dto.getFreeproductwillget())
                .targetproduct(dto.getTargetproduct())
                .build();
    }
    public PromotionDto getPromotion(ByeN_GetNFreeDto dto){
        return PromotionDto.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .promotiontype(dto.getPromotiontype())
                .startdate(dto.getStartdate())
                .enddate(dto.getEnddate())
                .onlineshopid(dto.getOnlineshopid())
                .build();
    }

//    applic to the same product ,like bye 2 t-shirt get the third for free
}
