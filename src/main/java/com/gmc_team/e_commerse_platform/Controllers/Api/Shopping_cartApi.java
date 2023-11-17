package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.OrderDto;
import com.gmc_team.e_commerse_platform.Dto.Shopping_cartDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Shopping_cart")

public interface Shopping_cartApi {
    @GetMapping(value = "/Shopping_cart/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Shopping_cartDto findById(@PathVariable("Id") Long Id);



    @PostMapping(value = "/Shopping_cart/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Shopping_cartDto save(@RequestBody Shopping_cartDto dto);

    @PostMapping(value = "/Shopping_cart/convert_into_order" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    OrderDto convert_shoppingcart_into_order(@RequestBody Shopping_cartDto dto);

    @PostMapping(value = "/Shopping_cart/convert_into_orderById/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    OrderDto convert_shoppingcart_into_order(@PathVariable("id")Long dto);

    @GetMapping(value = "/Shopping_cart/findByCustomerId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Shopping_cartDto> findByCustomerId(@PathVariable("Id")Long Id);

    @DeleteMapping(value = "/Shopping_cart/delete/{shopping_CartId}" )
    void delete( @PathVariable("shopping_CartId") Long Var_Id);
}
