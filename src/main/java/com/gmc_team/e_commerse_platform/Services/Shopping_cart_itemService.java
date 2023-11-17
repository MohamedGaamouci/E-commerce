package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Shopping_cart_itemDto;

public interface Shopping_cart_itemService {
    Shopping_cart_itemDto findById(Long Id);
    Shopping_cart_itemDto save(Shopping_cart_itemDto dto);

    void delete(Long shoppingCartItemId);


}
