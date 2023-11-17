package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ProductDto {
    private Long Id;
    private String Name;
    private SKUDto SKU;
    private BigDecimal price;
    private List<DescriptionsDto> descriptionsDtos;
    private CategoryDto categoryDto;
    private List<ImagesDto> imagesDtos;
    private List<Product_itemDto> productitems;
    private List<Product_reviewDto> product_reviewDtos ;
    private Long online_shop;
    private Promotion_detailDto promotion;
    private Integer minimum_order_qte;


    public static Product toEntity(ProductDto dto){
        if(dto == null)return null;
        else{
            Product product =new Product();
            product.setId(dto.getId());
            product.setName(dto.getName().trim());
            product.setSku(SKUDto.toEntity(dto.getSKU()));
            if(dto.getDescriptionsDtos() != null){
                List<Descriptions> desc = new ArrayList<>();
                dto.getDescriptionsDtos().forEach(des-> desc.add(DescriptionsDto.toEntity(des)));
                product.setDescriptions(desc);
            }
            product.setCategory(CategoryDto.toEntity(dto.getCategoryDto()));
            product.setOnlineshop(dto.getOnline_shop());
            if(dto.getImagesDtos() != null){
                List<Images> imgs = new ArrayList<>();
                dto.getImagesDtos().forEach(des-> imgs.add(ImagesDto.toEntity(des)));
            product.setImages(imgs);
            }
            if(dto.getProduct_reviewDtos() != null){
                List<Product_review> reviews = new ArrayList<>();
                dto.getProduct_reviewDtos().forEach(rev-> reviews.add(Product_reviewDto.toEntity(rev)));
            product.setProduct_review(reviews);
            }
            if(dto.getProductitems() != null){
                List<Product_item> list = new ArrayList<>();
                dto.getProductitems().forEach(item -> list.add(Product_itemDto.toEntity(item)));
            product.setProductitems(list);
            }

            product.setPromotion(Promotion_detailDto.toEntity(dto.getPromotion()));
            product.setMinimumorderqte(dto.getMinimum_order_qte());
            product.setPrice(dto.getPrice());

            return product;
        }
    }
    public static ProductDto fromEntity(Product product,boolean go_with_review){
        if(product == null)return null;
        else{
            if(go_with_review){
                List<ImagesDto> imgs = new ArrayList<>();
                if(product.getImages() != null){
                    product.getImages().forEach(des-> imgs.add(ImagesDto.fromEntity(des)));
                }
                List<DescriptionsDto> desc = new ArrayList<>();
                if(product.getDescriptions() != null){

                    product.getDescriptions().forEach(des-> desc.add(DescriptionsDto.fromEntity(des)));
                }

                List<Product_reviewDto> reviews = new ArrayList<>();
                if(product.getProduct_review() != null){
                    product.getProduct_review().forEach(rev-> reviews.add(Product_reviewDto.fromEntity(rev)));

                }
                List<Product_itemDto> list = new ArrayList<>();
                if(product.getProductitems() != null){
                    product.getProductitems().forEach(item -> list.add(Product_itemDto.fromEntity(item)));
                }


                return ProductDto.builder()
                        .Id(product.getId())
                        .Name(product.getName())
                        .SKU(SKUDto.fromEntity(product.getSku()))
                        .descriptionsDtos(desc)
                        .imagesDtos(imgs)
                        .online_shop(product.getOnlineshop())
                        .categoryDto(CategoryDto.fromEntity(product.getCategory()))
                        .product_reviewDtos(reviews)
                        .productitems(list)
                        .promotion(Promotion_detailDto.fromEntity(product.getPromotion()))
                        .minimum_order_qte(product.getMinimumorderqte())
                        .price(product.getPrice())
                        .build();
            }else {
                List<ImagesDto> imgs = new ArrayList<>();
                if(product.getImages() != null){
                    product.getImages().forEach(des-> imgs.add(ImagesDto.fromEntity(des)));
                }
                List<DescriptionsDto> desc = new ArrayList<>();
                if(product.getDescriptions() != null){

                    product.getDescriptions().forEach(des-> desc.add(DescriptionsDto.fromEntity(des)));
                }

                List<Product_itemDto> list = new ArrayList<>();
                if(product.getProductitems() != null){
                    product.getProductitems().forEach(item -> list.add(Product_itemDto.fromEntity(item)));
                }

                return ProductDto.builder()
                        .Id(product.getId())
                        .Name(product.getName())
                        .SKU(SKUDto.fromEntity(product.getSku()))
                        .descriptionsDtos(desc)
                        .imagesDtos(imgs)
                        .online_shop(product.getOnlineshop())
                        .categoryDto(CategoryDto.fromEntity(product.getCategory()))
                        .productitems(list)
                        .promotion(Promotion_detailDto.fromEntity(product.getPromotion()))
                        .minimum_order_qte(product.getMinimumorderqte())
                        .price(product.getPrice())
                        .build();
            }
        }
    }
}
