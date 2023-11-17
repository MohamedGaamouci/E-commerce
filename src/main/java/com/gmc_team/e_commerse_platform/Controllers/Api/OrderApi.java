package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.OrderDto;
import com.gmc_team.e_commerse_platform.models.Order_status;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Customer_order")
public interface OrderApi {

    @PostMapping(value = "/Customer_order/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    OrderDto save(@RequestBody OrderDto dto);

    @GetMapping(value = "/Customer_order/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto findById(@PathVariable("Id") Long Id);

    @GetMapping(value = "/Customer_order/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAll();

    @GetMapping(value = "/Customer_order/findByOrder_status/{status}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findByOrder_status(@PathVariable("status") Order_status statusId);
    @GetMapping(value = "/Customer_order/findByShippingMethod/{ShippingId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findByShippingMethodDto(@PathVariable("ShippingId") Long ShippingId);
    @GetMapping(value = "/Customer_order/findBycustomer_id/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findBycustomer_id(@PathVariable("Id") Long Id);
    @GetMapping(value = "/Customer_order/findByPaymentMethodId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findByPaymentMethodDtoId(@PathVariable("Id") Long Id);

    @GetMapping(value = "/Customer_order/findByShipping_addressId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findByShipping_addressDtoId(@PathVariable("Id") Long Id);

    @GetMapping(value = "/Customer_order/findByreviewId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto findByreviewDtoId(@PathVariable("Id") Long Id);

    @PutMapping(value = "/Customer_order/update_status/{orderid}" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    OrderDto update_status(@RequestBody Order_status status ,@PathVariable("orderid") Long orderid);

    @PutMapping(value = "/Customer_order/cancel_or_return_order/{orderid}" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    OrderDto cancel_or_return_Order(@RequestBody Order_status status ,@PathVariable("orderid") Long orderid);

}
