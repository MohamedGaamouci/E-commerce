package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Api("/Description")
public interface DescriptionApi {

//    @ApiOperation(value = "Get a Description with an id", response = Descriptions.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Description Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Description Object Not Found")
//    })
    @GetMapping(value = "/Description/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    DescriptionsDto findById(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "save a Description /modify", response = Descriptions.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Description Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The Description Object Not Valid")
//    })
    @PostMapping(value = "/Description/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    DescriptionsDto save(@RequestBody DescriptionsDto dto);


//    @ApiOperation(value = "Get all Description", response = Descriptions.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Description Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Description Object Not Found")
//    })
    @GetMapping(value = "/Description/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<DescriptionsDto> findAll();

//    @ApiOperation(value = "Get a Description with the store id", response = Descriptions.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Description Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Description Object Not Found")
//    })
    @GetMapping(value = "/Description/findByOnline_shopId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<DescriptionsDto> findByOnline_shopId(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "Get a Description with title", response = Descriptions.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Description Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Description Object Not Found")
//    })
    @GetMapping(value = "/Description/findByTitle/{title}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<DescriptionsDto> findByTitle(@PathVariable("title") String title);

}
