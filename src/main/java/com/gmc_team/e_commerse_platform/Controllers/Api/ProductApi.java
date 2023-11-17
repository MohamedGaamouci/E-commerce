package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Product")
public interface ProductApi {

    @GetMapping(value = "/Product/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDto findById(@PathVariable("Id") Long Id);

    @PostMapping(value = "/Product/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    ProductDto save(@RequestBody ProductDto dto);

    @GetMapping(value = "/Product/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAll();

    @GetMapping(value = "/Product/findByName/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findByName(@PathVariable("Name")String Name);

    @GetMapping(value = "/Product/findAllBySKUId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAllProductBySKUId(@PathVariable("Id")Long Id);

    @GetMapping(value = "/Product/findAllBySKUName/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAllProductBySKUId(@PathVariable("Name")String Name);
    @DeleteMapping(value = "/Product/delete/{Product_Id}")
    void deleteProduct(@PathVariable("Product_Id") Long Id);

    @GetMapping(value = "/Product/findAllDescriptionByProductId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<DescriptionsDto> findAllDescriptionByProductId(@PathVariable("Id")Long Id);

    @GetMapping(value = "/Product/findByCategory/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findProductByCategory(@PathVariable("Id")Long CategoryId);

    @GetMapping(value = "/Product/findAllImagesByProductId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ImagesDto> findAllImagesByProductId(@PathVariable("Id")Long Id);

    @GetMapping(value = "/Product/findAllProduct_reviewByProductId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Product_reviewDto> findAllProduct_reviewByProductId(@PathVariable("Id")Long Id);
    @GetMapping(value = "/Product_item/findAllByProductId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Product_itemDto> findAllVariationProductByProductId(@PathVariable("Id") Long Id);

    @PutMapping(value = "/Product/update_promotion/{product_id}" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    ProductDto update_promotion_on_product(@RequestBody Promotion_detailDto dto ,@PathVariable("product_id") Long product_id);


}
