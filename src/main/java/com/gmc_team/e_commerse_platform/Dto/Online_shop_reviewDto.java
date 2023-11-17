package com.gmc_team.e_commerse_platform.Dto;


import com.gmc_team.e_commerse_platform.models.Online_shop_review;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Online_shop_reviewDto {
    private Long Id;
    private Integer store_rating;
    private String comment;
    private Long customers_idDto;
    private Long online_shop_idDto;
    public static Online_shop_review toEntity(Online_shop_reviewDto dto){
        if(dto == null )return null;
        else{
            Online_shop_review review = new Online_shop_review();
            review.setId(dto.getId());
            review.setStorerating(dto.getStore_rating());
            review.setComment(dto.getComment().trim());
            review.setCustomersid(dto.getCustomers_idDto());
            review.setOnlineshop(dto.getOnline_shop_idDto());
            return review;
        }
    }
    public static Online_shop_reviewDto fromEntity(Online_shop_review review){
        if(review == null )return null;
        else return Online_shop_reviewDto.builder()
                .Id(review.getId())
                .store_rating(review.getStorerating())
                .comment(review.getComment())
                .customers_idDto(review.getCustomersid())
                .online_shop_idDto(review.getOnlineshop())
                .build();
    }
}
