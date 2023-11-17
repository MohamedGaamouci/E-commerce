package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

//@Api("/Product_item")
public interface Product_itemApi {

    @GetMapping(value = "/Product_item/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Product_itemDto findById(@PathVariable("Id") Long Id);


    @PostMapping(value = "/Product_item/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Product_itemDto save(@RequestBody Product_itemDto Id);


    @GetMapping(value = "/Product_item/UpdateQteProduct_item" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Product_itemDto UpdateQteProduct_item(@RequestParam("IdProduct") Long IdProduct ,
                                          @RequestParam("qte") BigDecimal qte);

    @DeleteMapping(value = "/Product_item/delete/{Id}")
    void delete(@PathVariable("Id") Long Id);
}
