package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.SellersDto;
import com.gmc_team.e_commerse_platform.models.Roles;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Seller")
public interface SellerApi {


    @GetMapping(value = "/Seller/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    SellersDto findById(@PathVariable("Id")Long Id);


    @PostMapping(value = "/Seller/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    SellersDto save(@RequestBody SellersDto dto);

    @GetMapping(value = "/Seller/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)

    List<SellersDto> findAll();
    @GetMapping(value = "/Seller/findByfirstNameAndSecondName" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<SellersDto> findByfirstNameAndSecondName(@RequestParam("firstName") String firstName
            ,@RequestParam("secondName") String secondName);

    @GetMapping(value = "/Seller/findByUserName/{username}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    SellersDto findByUserName(@PathVariable("username")String username);


    @GetMapping(value = "/Seller/findByEmail/{Email}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    SellersDto findByEmail(@PathVariable("Email")String Email);

    @GetMapping(value = "/Seller/findByGender/{gender}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<SellersDto> findByGender(@PathVariable("gender")String gender);

    @PostMapping(value = "/Seller/findByRole" ,produces = MediaType.APPLICATION_JSON_VALUE
                                ,consumes = MediaType.APPLICATION_JSON_VALUE)
    List<SellersDto> findByRole(@RequestBody List<Roles> rolesName);

    @DeleteMapping(value = "/Seller/delete/{Seller_Id}")
    void delete(@PathVariable("Seller_Id") Long Id);

    @GetMapping(value = "/Seller/activate/{Seller_Id}")
    void activate(@PathVariable("Seller_Id") Long Id);

    @GetMapping(value = "/Seller/disactivate/{Seller_Id}")
    void disactivate(@PathVariable("Seller_Id") Long Id);
}
