package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.ImagesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Images")
public interface ImagesApi {

//    @ApiOperation(value = "Get a Images with an id", response = Images.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Images Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Images Object Not Found")
//    })
    @GetMapping(value = "/Images/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ImagesDto findById(@PathVariable("Id") Long id);

//    @ApiOperation(value = "save a Images /modify", response = Images.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Images Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The Images Object Not Valid")
//    })
    @PostMapping(value = "/Images/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    ImagesDto save(@RequestBody ImagesDto dto);

//    @ApiOperation(value = "Get a Images with title", response = Images.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Images Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Images Object Not Found")
//    })
    @GetMapping(value = "/Images/findByTitle/{title}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ImagesDto> findByTitle(@PathVariable String title);

//    @ApiOperation(value = "Get a Images with a Url", response = Images.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Images Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Images Object Not Found")
//    })
    @GetMapping(value = "/Images/findByURL/{Url}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ImagesDto> findByURL(@PathVariable("Url") String Url);

//    @ApiOperation(value = "delete a Images with an id", response = Images.class ,httpMethod = "DELETE")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Images Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Images Object Not Found")
//    })
    @DeleteMapping(value = "/Images/delete/{Images_Id}")
    void delete(@PathVariable("Images_Id") Long Images_Id);
}
