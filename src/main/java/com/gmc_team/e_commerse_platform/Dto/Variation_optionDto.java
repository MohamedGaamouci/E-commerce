package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Variation_option;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Variation_optionDto {

    private Long Id;
    private VariationDto variation;
    private String option_value;
    private Long online_shop;

    public static Variation_option toEntity(Variation_optionDto dto){
        if(dto == null)return null;
        else {
            Variation_option option =new Variation_option();
            option.setId(dto.getId());
            option.setVariation(VariationDto.toEntity(dto.getVariation()));
            option.setOptionvalue(dto.getOption_value().trim());
            option.setOnlineshop(dto.getOnline_shop());


            return option;
        }
    }

    public static Variation_optionDto fromEntity(Variation_option option,boolean go_with_variation){
        if(option == null)return null;
        else {
            if(!go_with_variation){
                return Variation_optionDto.builder()
                        .Id(option.getId())
                        .online_shop(option.getOnlineshop())
                        .option_value(option.getOptionvalue())
                        .build();

            }else {
                return Variation_optionDto.builder()
                        .Id(option.getId())
                        .variation(VariationDto.fromEntity(option.getVariation() ,false))
                        .online_shop(option.getOnlineshop())
                        .option_value(option.getOptionvalue())
                        .build();

            }

        }
    }

}
