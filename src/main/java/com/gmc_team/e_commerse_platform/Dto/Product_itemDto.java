package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder

public class Product_itemDto {
    private Long Id;
    private Long productDto;

    private BigDecimal price ;

    private BigDecimal qte;
    private List<ImagesDto> imagesDtos;
    private Long online_shop;
    private List<Variation_optionDto> variation_optionDtos;
    private List<VariationDto> variations;

    public static Product_item toEntity(Product_itemDto dto){
        if(dto == null)return null;
        else{
            Product_item item = new Product_item();
            item.setId(dto.getId());
            item.setProduct(dto.getProductDto());

            item.setQte(dto.getQte());
                if(dto.getImagesDtos() != null){
                List<Images> images = new ArrayList<>();
                dto.getImagesDtos().forEach(img-> images.add(ImagesDto.toEntity(img)));
                item.setImages(images);
                }
            item.setOnline_shop(dto.getOnline_shop());
            if(dto.getVariation_optionDtos() != null){
                List<Variation_option> vars = new ArrayList<>();
                dto.getVariation_optionDtos().forEach(var-> vars.add(Variation_optionDto.toEntity(var)));
                item.setVariation_option(vars);
            }
            if(dto.getVariations() != null) {
                List<Variation> var = new ArrayList<>();
                dto.getVariations().forEach(v -> var.add(VariationDto.toEntity(v)));
                item.setVariations(var);
            }
            item.setPrice(dto.getPrice());
//
            return item;
        }
    }
    public static Product_itemDto fromEntity(Product_item item){
        if(item == null)return null;
        else{

                List<Variation_optionDto> vars = new ArrayList<>();
                item.getVariation_option().forEach(var-> vars.add(Variation_optionDto.fromEntity(var ,true)));
                List<ImagesDto> images = new ArrayList<>();
                item.getImages().forEach(img-> images.add(ImagesDto.fromEntity(img)));
                List<VariationDto> var = new ArrayList<>();
                item.getVariations().forEach(v -> var.add(VariationDto.fromEntity(v ,false)));
            return Product_itemDto.builder()
                    .Id(item.getId())
                    .productDto(item.getProduct())
                    .qte(item.getQte())
                    .imagesDtos(images)
                    .online_shop(item.getOnline_shop())
                    .variation_optionDtos(vars)
                    .variations(var)
                    .price(item.getPrice())
                    .build();

        }
    }

}
