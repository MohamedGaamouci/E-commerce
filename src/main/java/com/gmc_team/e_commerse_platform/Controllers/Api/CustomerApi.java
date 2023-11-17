package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.CustomersDto;
import com.gmc_team.e_commerse_platform.Dto.ProductDto;
import com.gmc_team.e_commerse_platform.models.Roles;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Customer")
public interface CustomerApi {
//    @ApiOperation(value = "save a Customer /modify", response = Customers.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Valid")
//    })
    @PostMapping(value = "/Customer/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    CustomersDto save(@RequestBody CustomersDto dto);


//    @ApiOperation(value = "Get a Customer with an id", response = Customers.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @GetMapping(value = "/Customer/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CustomersDto findById(@PathVariable("Id") Long Id);


//    @ApiOperation(value = "Get a Customer with a username", response = Customers.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @GetMapping(value = "/Customer/findByUserName/{username}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CustomersDto findByUserName(@PathVariable("username") String username);

//    @ApiOperation(value = "Get all Customer", response = Customers.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customers Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customers Object Not Found")
//    })
    @GetMapping(value = "/Customer/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomersDto> findAll();

//    @ApiOperation(value = "Get a Customer with the first name and second name", response = Customers.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @GetMapping(value = "/Customer/findByNameAndSecondName" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomersDto> findByNameAndSecondName(@RequestParam("Name") String Name ,@RequestParam("SecondName") String SecondName);

//    @ApiOperation(value = "Get a Customer with an Email", response = Customers.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @GetMapping(value = "/Customer/findByEmail/{Email}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CustomersDto findByEmail(@PathVariable("Email") String Email);

//    @ApiOperation(value = "Get a Customer with an gender", response = Customers.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @GetMapping(value = "/Customer/findByGender/{gender}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomersDto> findByGender(@PathVariable("gender") String gender);

//    @ApiOperation(value = "Get a Customer with an rolesName", response = Customers.class ,httpMethod = "POST")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @PostMapping(value = "/Customer/findByRole" ,produces = MediaType.APPLICATION_JSON_VALUE
    ,consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CustomersDto> findByRole(@RequestBody List<Roles> rolesName);

//    @ApiOperation(value = "Get the favorite products with an customer id", response = Customers.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @GetMapping(value = "/Customer/findAllFavorite/{customerId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAllFavorite(@PathVariable("customerId") Long customerId);

//    @ApiOperation(value = "delete a Customer with an id", response = Customers.class ,httpMethod = "DELETE")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Customer Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Customer Object Not Found")
//    })
    @DeleteMapping(value = "/Customer/delete/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("customerId") Long Id);


}
