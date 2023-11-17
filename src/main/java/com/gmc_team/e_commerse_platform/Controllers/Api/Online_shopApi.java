package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Dto.SellersDto;
import com.gmc_team.e_commerse_platform.models.Specialities;
import com.gmc_team.e_commerse_platform.models.Store_status;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Online_shopApi {

    @GetMapping(value = "/Online_shop/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Online_shopDto findById(@PathVariable("Id") Long Id);


    @PostMapping(value = "/Online_shop/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Online_shopDto save(@RequestBody Online_shopDto dto);


    @GetMapping(value = "/Online_shop/findByName/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Online_shopDto> findByName(@PathVariable("Name") String Name);


    @GetMapping(value = "/Online_shop/findByOwnerId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Online_shopDto findByOwnerId(@PathVariable("Id") Long Id);


    @GetMapping(value = "/Online_shop/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Online_shopDto> findAll();


    @GetMapping(value = "/Online_shop/findByStore_status/{status}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Online_shopDto> findByStore_status(@PathVariable("status") Store_status status);


    @GetMapping(value = "/Online_shop/findByRating" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Online_shopDto> findByRating(@RequestParam("Haut") Float Haut ,@RequestParam("Base") Float Base);


    @GetMapping(value = "/Online_shop/findBySpeciality/{Speciality}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Online_shopDto> findBySpeciality(@PathVariable("Speciality") Specialities Speciality);


    @GetMapping(value = "/Online_shop/findByOtherSpeciality/{Speciality}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Online_shopDto> findByOtherSpeciality(@PathVariable("Speciality") String Speciality);


    @PostMapping(value = "/Online_shop/AddNewEmployee" ,produces = MediaType.APPLICATION_JSON_VALUE
            ,consumes = MediaType.APPLICATION_JSON_VALUE)
    Online_shopDto AddNewEmployee(@RequestBody SellersDto dto);



    @GetMapping(value = "/Online_shop/AddNewCustomer" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Online_shopDto AddNewCustomer(@RequestParam("customerid")Long customerid,@RequestParam("storeid")Long storeid);


    @GetMapping(value = "/Online_shop/disactivate/{Store_Id}")
    void disactivate(@PathVariable("Store_Id")Long storeId);


    @GetMapping(value = "/Online_shop/activate/{Store_Id}")
    void activate(@PathVariable("Store_Id")Long storeId);



    @GetMapping(value = "/Online_shop/getstatus/{Store_Id}")
    Store_status getstatus(@PathVariable("Store_Id")Long storeId);


    @DeleteMapping(value = "/Online_shop/delete_review")
    void delete_review(@RequestParam("reviewid")Long reviewId ,@RequestParam("storeid")Long storeid);


    @DeleteMapping(value = "/Online_shop/delete_description")
    void delete_description(@RequestParam("descriptionid")Long descriptionid ,@RequestParam("storeid")Long storeid);


    @GetMapping(value = "/Online_shop/addPaymentMethod")
    Online_shopDto addPaymentMethod(@RequestParam("paymentid")Long paymentid ,@RequestParam("storeid")Long storeid);

    @DeleteMapping(value = "/Online_shop/deletePaymentMethod")
    void deletePaymentMethod(@RequestParam("paymentid")Long paymentid ,@RequestParam("storeid")Long storeid);

    @DeleteMapping(value = "/Online_shop/deleteEmployee")
    void deleteEmployee(@PathVariable("employeeid")Long employeeid ,@RequestParam("storeid")Long storeid);


    @DeleteMapping(value = "/Online_shop/dissubscribeCustomer")
    void dissubscribeCustomer(@PathVariable("customerid")Long customerid ,@RequestParam("storeid")Long storeid);

}
