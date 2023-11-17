package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Order_lineApi;
import com.gmc_team.e_commerse_platform.Dto.Order_lineDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Order_lineServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Order_lineController implements Order_lineApi {
    private final Order_lineServiceImpl order_lineServiceImpl;

    public Order_lineController(Order_lineServiceImpl order_lineServiceImpl) {
        this.order_lineServiceImpl = order_lineServiceImpl;
    }

    @Override
    public Order_lineDto findById(Long Id) {
        return order_lineServiceImpl.findById(Id);
    }

    @Override
    public Order_lineDto save(Order_lineDto Id) {
        return order_lineServiceImpl.save(Id);
    }

    @Override
    public List<Order_lineDto> findByProduct(Long productId) {
        return order_lineServiceImpl.findByProduct(productId);
    }
}
