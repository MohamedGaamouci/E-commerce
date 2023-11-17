package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Shipping_methodApi;
import com.gmc_team.e_commerse_platform.Dto.Shipping_methodDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Shipping_methodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Shipping_methodController implements Shipping_methodApi {


    private final Shipping_methodServiceImpl service;

    @Autowired
    public Shipping_methodController(Shipping_methodServiceImpl service) {
        this.service = service;
    }

    @Override
    public Shipping_methodDto save(Shipping_methodDto dto) {
        return service.save(dto);
    }

    @Override
    public Shipping_methodDto findById(Long Id) {
        return service.findById(Id);
    }

    @Override
    public List<Shipping_methodDto> findAll() {
        return service.findAll();
    }

    @Override
    public Shipping_methodDto findByName(String shipping_Name) {
        return service.findByName(shipping_Name);
    }

    @Override
    public Shipping_methodDto findBycustomer_order(Long customer_order_ID) {
        return service.findBycustomer_order(customer_order_ID);
    }

    @Override
    public void delete(Long Shipping_methodId) {
        service.delete(Shipping_methodId);
    }
}
