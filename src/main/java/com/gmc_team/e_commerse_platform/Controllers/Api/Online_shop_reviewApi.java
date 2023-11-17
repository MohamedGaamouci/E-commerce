package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Online_shop_reviewDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Online_shop_review")
public interface Online_shop_reviewApi {

//    @ApiOperation(value = "Get a review with an id", response = Online_shop_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The review Object Not Found")
//    })
    @GetMapping(value = "/Online_shop_review/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Online_shop_reviewDto findById(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "save a review /modify", response = Online_shop_review.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The review Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The review Object Not Valid")
//    })
    @PostMapping(value = "/Online_shop_review/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Online_shop_reviewDto save(@RequestBody Online_shop_reviewDto Id);

//    @ApiOperation(value = "Get a review with Customer Id", response = Online_shop_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The review Object Not Found")
//    })
    @GetMapping(value = "/Online_shop_review/findByCustomerId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Online_shop_reviewDto findByCustomerId(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "Get a review with store Id", response = Online_shop_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The review Object Not Found")
//    })
    @GetMapping(value = "/Online_shop_review/findByOnline_shopId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Online_shop_reviewDto> findByOnline_shopId(@PathVariable("Id") Long Id);
//
//    @ApiOperation(value = "Get a review with Customer and store Id ", response = Online_shop_review.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The review Object Got successfully"),
//            @ApiResponse(code = 400, message = "The review Object Not Found")
//    })
    @GetMapping(value = "/Online_shop_review/findByCustomerIdAndOnline_shopId" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Online_shop_reviewDto findByCustomerIdAndOnline_shopId(@RequestParam("CustomerId") Long CustomerId
            ,@RequestParam("StoreId") Long StoreId);
}
