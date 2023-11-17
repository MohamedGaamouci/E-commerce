package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;

import java.math.BigDecimal;

public interface Product_itemService {
    Product_itemDto findById(Long Id);
    Product_itemDto save(Product_itemDto Id);


    Product_itemDto UpdateQteProduct_item(Long IdProduct , BigDecimal qte);

    void deleteProduct_itemById(Long Id);

}
