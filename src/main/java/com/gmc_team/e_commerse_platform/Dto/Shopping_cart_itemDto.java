package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Shopping_cart_item;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Shopping_cart_itemDto {
    private Long Id;
    private BigDecimal qte;
    private Product_itemDto product_item;
    private Long online_shop;
    public static Shopping_cart_item toEntity(Shopping_cart_itemDto dto){
        if(dto == null)return null;
        else{
            Shopping_cart_item item=new Shopping_cart_item();
            item.setId(dto.getId());
            item.setProduct_item(Product_itemDto.toEntity(dto.getProduct_item()));
            item.setQte(dto.getQte());
            item.setOnline_shop(dto.getOnline_shop());
            return item;
        }
    }

    public static Shopping_cart_itemDto fromEntity(Shopping_cart_item item){
        if(item == null)return null;
        else return Shopping_cart_itemDto.builder()
                .Id(item.getId())
                .qte(item.getQte())
                .product_item(Product_itemDto.fromEntity(item.getProduct_item()))
                .build();}

}
