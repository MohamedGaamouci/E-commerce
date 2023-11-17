package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Order_reviewDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Api("Order_review")
public interface Order_reviewApi {
//    @ApiOperation(value = "save a Order_review /modify", response = Order_review.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_review Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The Order_review Object Not Valid")
//    })
    @PostMapping(value = "/Order_review/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Order_reviewDto save(@RequestBody Order_reviewDto Id);


//    @ApiOperation(value = "Get a Order_review with an id", response = Order_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Order_review Object Not Found")
//    })
    @GetMapping(value = "/Order_review/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Order_reviewDto findById(@PathVariable("Id") Long Id);


//    @ApiOperation(value = "Get a Order_review with Customer_id", response = Order_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Order_review Object Not Found")
//    })
    @GetMapping(value = "/Order_review/findByCustomer_id/{Customer_id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Order_reviewDto findByCustomer_id(@PathVariable("Customer_id") Long Customer_id);


//    @ApiOperation(value = "Get a Order_review with a Rating", response = Order_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Order_review Object Not Found")
//    })
    @GetMapping(value = "/Order_review/findByRating/{Rating}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Order_reviewDto> findByRating(@PathVariable("Rating") Integer rating);


//    @ApiOperation(value = "Get a Order_review with a Customer_orderId", response = Order_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Order_review Object Not Found")
//    })
    @GetMapping(value = "/Order_review/findByCustomer_orderId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Order_reviewDto findByCustomer_orderId(@PathVariable("Id") Long Id);
}
