package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.*;
import com.gmc_team.e_commerse_platform.models.Order_status;

import java.util.List;

public interface OrderService {

    OrderDto save(OrderDto dto);
    OrderDto findById(Long Id);
    List<OrderDto> findAll();
    List<OrderDto> findByOrder_status(Order_status status);
    List<OrderDto> findByShippingMethodDto(Long Id);
    List<OrderDto> findBycustomer_id(Long Id);
    List<OrderDto> findByPaymentMethodDtoId(Long Id);
    List<OrderDto> findByShipping_addressDtoId(Long Id);
    OrderDto findByreviewDtoId(Long Id);
    OrderDto updateStatus(Order_status status ,Long orderid);

    OrderDto cancel_or_return_Order(Long orderid ,Order_status status);


}
