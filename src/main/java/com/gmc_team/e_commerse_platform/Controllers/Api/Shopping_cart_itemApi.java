package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Shopping_cart_itemDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//@Api("/Shopping_cart_item")
public interface Shopping_cart_itemApi {
    @GetMapping(value = "/Shopping_cart_item/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Shopping_cart_itemDto findById(@PathVariable("Id") Long Id);

    @PostMapping(value = "/Shopping_cart_item/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Shopping_cart_itemDto save(@RequestBody Shopping_cart_itemDto dto);
    @DeleteMapping(value = "/Shopping_cart_item/delete/{shopping_Cart_ItemId}" )
    void delete( @PathVariable("shopping_Cart_ItemId") Long shopping_Cart_ItemId);
}
