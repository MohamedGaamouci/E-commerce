package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.Order_lineDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Api("/Order_line")
public interface Order_lineApi {

//    @ApiOperation(value = "Get a Order_line with an id", response = Order_line.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_line Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Order_line Object Not Found")
//    })

    @GetMapping(value = "/Order_line/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Order_lineDto findById(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "save a Order_line /modify", response = Order_line.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_line Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The Order_line Object Not Valid")
//    })
    @PostMapping(value = "/Order_line/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Order_lineDto save(@RequestBody Order_lineDto Id);

//    @ApiOperation(value = "Get a Order_line with an productid", response = Order_line.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Order_line Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Order_line Object Not Found")
//    })
    @GetMapping(value = "/Order_line/findByProduct/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Order_lineDto> findByProduct(@PathVariable("Id") Long productId);
}
