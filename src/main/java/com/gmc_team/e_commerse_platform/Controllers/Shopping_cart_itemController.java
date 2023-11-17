package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Shopping_cart_itemApi;
import com.gmc_team.e_commerse_platform.Dto.Shopping_cart_itemDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Shopping_cart_itemServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Shopping_cart_itemController implements Shopping_cart_itemApi {
    private final Shopping_cart_itemServiceImpl shopping_cart_itemServiceImpl;

    public Shopping_cart_itemController(Shopping_cart_itemServiceImpl shopping_cart_itemServiceImpl) {
        this.shopping_cart_itemServiceImpl = shopping_cart_itemServiceImpl;
    }

    @Override
    public Shopping_cart_itemDto findById(Long Id) {
        return shopping_cart_itemServiceImpl.findById(Id);
    }

    @Override
    public Shopping_cart_itemDto save(Shopping_cart_itemDto dto) {
        return shopping_cart_itemServiceImpl.save(dto);
    }

    @Override
    public void delete(Long shopping_Cart_ItemId) {
        shopping_cart_itemServiceImpl.delete(shopping_Cart_ItemId);
    }
}
