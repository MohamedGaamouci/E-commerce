package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Order_reviewApi;
import com.gmc_team.e_commerse_platform.Dto.Order_reviewDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Order_reviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Order_reviewController implements Order_reviewApi {


    private final Order_reviewServiceImpl service;

    @Autowired
    public Order_reviewController(Order_reviewServiceImpl service) {
        this.service = service;
    }

    @Override
    public Order_reviewDto save(Order_reviewDto Id) {
        return service.save(Id);
    }

    @Override
    public Order_reviewDto findById(Long Id) {
        return service.findById(Id);
    }

    @Override
    public Order_reviewDto findByCustomer_id(Long Customer_id) {
        return service.findByCustomer_id(Customer_id);
    }

    @Override
    public List<Order_reviewDto> findByRating(Integer rating) {
        return service.findByRating(rating);
    }

    @Override
    public Order_reviewDto findByCustomer_orderId(Long Id) {
        return service.findByCustomer_orderId(Id);
    }
}
