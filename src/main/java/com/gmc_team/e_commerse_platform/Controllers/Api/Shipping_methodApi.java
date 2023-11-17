package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Shipping_methodDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Shipping_method")
public interface Shipping_methodApi {

    @PostMapping(value = "/Shipping_method/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Shipping_methodDto save(@RequestBody Shipping_methodDto dto);

    @GetMapping(value = "/Shipping_method/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Shipping_methodDto findById(@PathVariable("Id") Long Id);


    @GetMapping(value = "/Shipping_method/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Shipping_methodDto> findAll();

    @GetMapping(value = "/Shipping_method/findByName/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Shipping_methodDto findByName(@PathVariable("Name") String shipping_Name);

    @GetMapping(value = "/Shipping_method/findBycustomer_order/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Shipping_methodDto findBycustomer_order(@PathVariable("Id") Long customer_order_ID);

    @DeleteMapping(value = "/Shipping_method/delete/{Shipping_methodId}" )
    void delete( @PathVariable("Shipping_methodId") Long Shipping_methodId);
}
