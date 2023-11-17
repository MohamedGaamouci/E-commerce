package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Product_reviewDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Product_review")
public interface Product_reviewApi {

    @GetMapping(value = "/Product_review/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Product_reviewDto findById(@PathVariable("Id") Long Id);


    @PostMapping(value = "/Product_review/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Product_reviewDto save(@RequestBody Product_reviewDto Id);


    @GetMapping(value = "/Product_review/findAllByRating/{rating}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Product_reviewDto> findAllByRating(@PathVariable("rating") Integer rating);

    @GetMapping(value = "/Product_review/findByProductId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Product_reviewDto> findByProductId(@PathVariable("Id")Long Id);

    @GetMapping(value = "/Product_review/findByCustomerId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Product_reviewDto findByCustomerId(@PathVariable("Id") Long Id);

    @DeleteMapping(value = "/Product_review/delete/{Product_reviewId}" )
    void delete( @PathVariable("Product_reviewId") Long Product_reviewId);

}
