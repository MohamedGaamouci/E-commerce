package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Shipping_methodDto;

import java.util.List;

public interface Shipping_methodService {
    Shipping_methodDto findById(Long Id);
    Shipping_methodDto save(Shipping_methodDto dto);
    List<Shipping_methodDto> findAll();
    Shipping_methodDto findByName(String shipping_Name);
    Shipping_methodDto findBycustomer_order(Long customer_order_ID);
    void delete(Long shippingMethodId);
}
