package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Order_review;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order_reviewDto {
    private Long Id;
    private Long customer_id;
    private Long customer_orderDto;
    private Integer rating;
    private String comment;
    private Long online_shop;
    public static Order_review toEntity(Order_reviewDto dto){
        if(dto == null)return null;
        else{
            Order_review review = new Order_review();
            review.setId(dto.getId());
            review.setCustomerid(dto.getCustomer_id());
            review.setCustomerorder(dto.getCustomer_orderDto());
            review.setRating(dto.getRating());
            review.setComment(dto.getComment().trim());
            review.setOnlineshop(dto.getOnline_shop());
            return review;
        }
    }
    public static Order_reviewDto fromEntity(Order_review review){
        if(review == null)return null;
        else return Order_reviewDto.builder()
                .Id(review.getId())
                .customer_orderDto(review.getCustomerorder())
                .rating(review.getRating())
                .comment(review.getComment())
                .online_shop(review.getOnlineshop())
                .build();
    }
}
