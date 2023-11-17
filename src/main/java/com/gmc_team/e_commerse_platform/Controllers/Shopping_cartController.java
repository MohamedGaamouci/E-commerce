package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Shopping_cartApi;
import com.gmc_team.e_commerse_platform.Dto.OrderDto;
import com.gmc_team.e_commerse_platform.Dto.Shopping_cartDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Shopping_cartServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Shopping_cartController implements Shopping_cartApi {
    private final Shopping_cartServiceImpl shopping_cartServiceImpl;

    public Shopping_cartController(Shopping_cartServiceImpl shopping_cartServiceImpl) {
        this.shopping_cartServiceImpl = shopping_cartServiceImpl;
    }

    @Override
    public Shopping_cartDto findById(Long Id) {
        return shopping_cartServiceImpl.findById(Id);
    }

    @Override
    public Shopping_cartDto save(Shopping_cartDto dto) {
        return shopping_cartServiceImpl.save(dto);
    }

    @Override
    public OrderDto convert_shoppingcart_into_order(Shopping_cartDto dto) {
        return shopping_cartServiceImpl.convert_shoppingcart_into_order(dto);
    }

    @Override
    public OrderDto convert_shoppingcart_into_order(Long id) {
        return shopping_cartServiceImpl.convert_shoppingcart_into_order(id);
    }

    @Override
    public List<Shopping_cartDto> findByCustomerId(Long Id) {
        return shopping_cartServiceImpl.findByCustomerId(Id);
    }

    @Override
    public void delete(Long shopping_CartId) {
        shopping_cartServiceImpl.delete(shopping_CartId);
    }
}
