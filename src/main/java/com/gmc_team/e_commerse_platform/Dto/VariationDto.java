package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Variation;
import com.gmc_team.e_commerse_platform.models.Variation_option;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class VariationDto {
    private Long Id;
    private String Name;
    private Long online_shop;
    private List<Variation_optionDto> variation_optionDtos;
    public static Variation toEntity(VariationDto dto){
        if(dto == null)return null;
        else {
            Variation variation = new Variation();

            variation.setId(dto.getId());
            variation.setName(dto.getName().trim());
            variation.setOnlineshop(dto.getOnline_shop());
            if(dto.getVariation_optionDtos() != null){
                List<Variation_option> list = new ArrayList<>();
                dto.getVariation_optionDtos().forEach(c -> list.add(Variation_optionDto.toEntity(c)));
            variation.setVariationoption(list);
            }
            return variation;
        }}

    public static VariationDto fromEntity(Variation variation ,boolean go_with_options) {
        if(variation == null)return null;
        else {
            if(go_with_options){
                List<Variation_optionDto> list = new ArrayList<>();
                if(variation.getVariationoption() != null){
                    variation.getVariationoption().forEach(c -> list.add(Variation_optionDto.fromEntity(c ,false)));

                }
                return VariationDto.builder()
                        .Id(variation.getId())
                        .Name(variation.getName())
                        .online_shop(variation.getOnlineshop())
                        .variation_optionDtos(list)
                        .build();
            }else{
                return VariationDto.builder()
                        .Id(variation.getId())
                        .Name(variation.getName())
                        .online_shop(variation.getOnlineshop())
                        .build();
            }

        }
    }


}

