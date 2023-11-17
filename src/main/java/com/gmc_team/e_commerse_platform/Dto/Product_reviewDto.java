package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Product_review;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product_reviewDto {
    private Long Id;
    private Integer rating;
    private String comment;
    private Long online_shop;
    private Long productDto;
    private Long customer_id;

    public static Product_review toEntity(Product_reviewDto dto){
        if(dto == null)return null;
        else{
            Product_review review =new Product_review();
            review.setId(dto.getId());
            review.setRating(dto.getRating());
            review.setComment(dto.getComment().trim());
            review.setOnlineshop(dto.getOnline_shop());
            review.setProduct(dto.getProductDto());
            review.setCustomerid(dto.getCustomer_id());
            return review;
        }
    }
    public static Product_reviewDto fromEntity(Product_review review ){
        if(review == null)return null;
        else
        {
            return Product_reviewDto.builder()
                    .Id(review.getId())
                    .comment(review.getComment())
                    .rating(review.getRating())
                    .online_shop(review.getOnlineshop())
                    .productDto(review.getProduct())
                    .customer_id(review.getCustomerid())
                    .build();
        }

    }

}
