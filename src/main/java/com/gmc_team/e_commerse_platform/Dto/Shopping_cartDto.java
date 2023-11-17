package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Shopping_cart;
import com.gmc_team.e_commerse_platform.models.Shopping_cart_item;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Shopping_cartDto {

    private Long Id;
    private List<Shopping_cart_itemDto> shopping_listDto;
    private CustomersDto customersId;
    private Long online_shop;
    public static Shopping_cart toEntity(Shopping_cartDto dto){
        if(dto == null)return null;
        else{
            Shopping_cart cart = new Shopping_cart();
                List<Shopping_cart_item> carts = new ArrayList<>();
            if(dto.getShopping_listDto() != null){
                 dto.getShopping_listDto().forEach(c -> carts.add(Shopping_cart_itemDto.toEntity(c)));
            }


            cart.setId(dto.getId());
            cart.setShoppinglist(carts);
            cart.setCustomers(CustomersDto.toEntity(dto.getCustomersId()));
            cart.setOnline_shop(dto.getOnline_shop());
            return cart;
        }
    }
    public static Shopping_cartDto fromEntity(Shopping_cart cart) {
        if (cart == null) return null;
        else {
                List<Shopping_cart_itemDto> carts = new ArrayList<>();
            if(cart.getShoppinglist() != null){
                cart.getShoppinglist().forEach(c -> carts.add(Shopping_cart_itemDto.fromEntity(c)));

            }
            return Shopping_cartDto.builder()
                    .Id(cart.getId())
                    .shopping_listDto(carts)
                    .customersId(CustomersDto.fromEntity(cart.getCustomers() ,true))
                    .online_shop(cart.getOnline_shop())
                    .build();
        }
    }

}
