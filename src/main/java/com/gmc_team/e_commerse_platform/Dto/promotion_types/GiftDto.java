package com.gmc_team.e_commerse_platform.Dto.promotion_types;

import com.gmc_team.e_commerse_platform.Dto.ImagesDto;
import com.gmc_team.e_commerse_platform.models.Images;
import com.gmc_team.e_commerse_platform.models.promotion_types.Gift;
import com.gmc_team.e_commerse_platform.models.promotion_types.num_product_condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiftDto{
    private Long id;
    private String giftname;
    private String description;
    private List<num_product_conditionDto> products_condition;
    private List<ImagesDto> giftimages;
    private Long onlineshop;

        public static GiftDto fromEntity(Gift dto){
        if (dto == null) return null;
        else{
            List<ImagesDto> list = new ArrayList<>();
            if(dto.getGiftimages() != null){
                list.addAll(dto.getGiftimages().stream()
                        .map(ImagesDto::fromEntity)
                        .toList());
            }
            List<num_product_conditionDto> list2 = new ArrayList<>();
            if(dto.getProducts() != null){
                list2.addAll(dto.getProducts().stream()
                        .map(num_product_conditionDto::fromEntity)
                        .toList());
            }
            return GiftDto.builder()
                    .id(dto.getId())
                    .giftname(dto.getGiftname())
                    .giftimages(list)
                    .description(dto.getDescription())
                    .onlineshop(dto.getOnlineshop())
                    .products_condition(list2).build();
        }
    }

    public static Gift toEntity(GiftDto dto){
        if (dto == null) return null;
        else{
            List<Images> list = new ArrayList<>();
            if(dto.getGiftimages() != null){
                list.addAll(dto.getGiftimages().stream()
                        .map(ImagesDto::toEntity)
                        .toList());
            }
            List<num_product_condition> list2 = new ArrayList<>();
            if(dto.getProducts_condition() != null){
                list2.addAll(dto.getProducts_condition().stream()
                        .map(num_product_conditionDto::toEntity)
                        .toList());
            }
            return Gift.builder()
                    .id(dto.getId())
                    .giftname(dto.getGiftname())
                    .giftimages(list)
                    .description(dto.getDescription())
                    .onlineshop(dto.getOnlineshop())
                    .products(list2)
                    .build();
        }
    }
}
