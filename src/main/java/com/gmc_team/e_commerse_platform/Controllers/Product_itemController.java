package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Product_itemApi;
import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Product_itemServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Product_itemController implements Product_itemApi {
    private final Product_itemServiceImpl product_itemServiceImpl;

    public Product_itemController(Product_itemServiceImpl product_itemServiceImpl) {
        this.product_itemServiceImpl = product_itemServiceImpl;
    }

    @Override
    public Product_itemDto findById(Long Id) {
        return product_itemServiceImpl.findById(Id);
    }

    @Override
    public Product_itemDto save(Product_itemDto Id) {
        return product_itemServiceImpl.save(Id);
    }



    @Override
    public Product_itemDto UpdateQteProduct_item(Long IdProduct, BigDecimal qte) {
        return product_itemServiceImpl.UpdateQteProduct_item(IdProduct ,qte);
    }

    @Override
    public void delete(Long Id) {
        product_itemServiceImpl.deleteProduct_itemById(Id);
    }
}
