package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.OrderApi;
import com.gmc_team.e_commerse_platform.Dto.OrderDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.OrderServiceImpl;
import com.gmc_team.e_commerse_platform.models.Order_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OrderController implements OrderApi {
    private OrderServiceImpl service;

    @Autowired
    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @Override
    public OrderDto save(OrderDto dto) {
        return service.save(dto);
    }

    @Override
    public OrderDto findById(Long Id) {
        return service.findById(Id);
    }

    @Override
    public List<OrderDto> findAll() {
        return service.findAll();
    }

    @Override
    public List<OrderDto> findByOrder_status(Order_status statusId) {
        return service.findByOrder_status(statusId);
    }

    @Override
    public List<OrderDto> findByShippingMethodDto(Long ShippingId) {
        return service.findByShippingMethodDto(ShippingId);
    }

    @Override
    public List<OrderDto> findBycustomer_id(Long Id) {
        return service.findBycustomer_id(Id);
    }

    @Override
    public List<OrderDto> findByPaymentMethodDtoId(Long Id) {
        return service.findByPaymentMethodDtoId(Id);
    }

    @Override
    public List<OrderDto> findByShipping_addressDtoId(Long Id) {
        return service.findByShipping_addressDtoId(Id);
    }

    @Override
    public OrderDto findByreviewDtoId(Long Id) {
        return service.findByreviewDtoId(Id);
    }

    @Override
    public OrderDto update_status(Order_status status, Long orderid) {
        return service.updateStatus(status ,orderid);
    }

    @Override
    public OrderDto cancel_or_return_Order(Order_status status, Long orderid) {
        return service.cancel_or_return_Order(orderid ,status);
    }
}
