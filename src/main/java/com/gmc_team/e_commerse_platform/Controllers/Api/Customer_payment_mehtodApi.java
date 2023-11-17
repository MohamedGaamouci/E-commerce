package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Customer_payment_mehtodDto;
import com.gmc_team.e_commerse_platform.models.Payment_type;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Api("/Payment_method")
public interface Customer_payment_mehtodApi {

//    @ApiOperation(value = "save a Payment_method /modify", response = Payment_method.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The payment method Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The payment method Object Not Valid")
//    })
    @PostMapping(value = "/Payment_method/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Customer_payment_mehtodDto save(@RequestBody Customer_payment_mehtodDto dto);

//    @ApiOperation(value = "Get a Payment_method with an id", response = Payment_method.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Payment_method Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Payment_method Object Not Found")
//    })
    @GetMapping(value = "/Payment_method/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Customer_payment_mehtodDto findById(@PathVariable("Id") Long Id);


//    @ApiOperation(value = "Get all Payment_method ", response = Payment_method.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Payment methods Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Payment methods Object Not Found")
//    })
    @GetMapping(value = "/Payment_method/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Customer_payment_mehtodDto> findAll();


//    @ApiOperation(value = "Get a Payment_method with the Payment_type",
//            notes = ""
//            ,response = Payment_method.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Payment_method Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Payment_method Object Not Found")
//    })
    @GetMapping(value = "/Payment_method/findByPayment_type/{Payment_type}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Customer_payment_mehtodDto> findByPayment_type(@PathVariable("Payment_type")Payment_type payment_type);


//    @ApiOperation(value = "Get a Payment_method with the Provider", response = Payment_method.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Payment_method Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Payment_method Object Not Found")
//    })
    @GetMapping(value = "/Payment_method/findByProvider/{Provider}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Customer_payment_mehtodDto> findByProvider(@PathVariable("Provider") String Provider);

}
