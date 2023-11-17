package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.OrderDto;
import com.gmc_team.e_commerse_platform.Dto.Shopping_cartDto;

import java.util.List;

public interface Shopping_cartService {
    Shopping_cartDto save(Shopping_cartDto dto);
    Shopping_cartDto findById(Long Id);
    List<Shopping_cartDto> findByCustomerId(Long Id);
    void delete(Long shoppingCartId);
    OrderDto convert_shoppingcart_into_order(Shopping_cartDto dto);
    OrderDto convert_shoppingcart_into_order(Long id);


}
