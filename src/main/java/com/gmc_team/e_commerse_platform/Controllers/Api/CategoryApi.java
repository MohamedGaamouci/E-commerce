package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Category")
public interface CategoryApi {

//    @ApiOperation(value = "save a Category /modify", response = Category.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Category Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The Category Object Not Valid")
//    })
    @PostMapping(value = "/Category/save" ,produces = MediaType.APPLICATION_JSON_VALUE
            ,consumes =MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto dto);


//    @ApiOperation(value = "Get a Category with an id", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrator Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Administrator Object Not Found")
//    })
    @GetMapping(value = "/Category/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "Get a Category with the name", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Category Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Category Object Not Found")
//    })
    @GetMapping(value = "/Category/findByName/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByName(@PathVariable("Name") String Name);

//    @ApiOperation(value = "Get all Category", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Categories Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Categories Object Not Found")
//    })
    @GetMapping(value = "/Category/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

//    @ApiOperation(value = "Get a Category with parent id category", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Category Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Category Object Not Found")
//    })
    @GetMapping(value = "/Category/findByParetCatId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findByParent_Category(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "delete a Category with the id", response = Administrators.class ,httpMethod = "DELETE")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Category Object deleted successfully"),
//            @ApiResponse(code = 400, message = "The Category Object Not Found or in use")
//    })
    @DeleteMapping(value = "/Category/delete/{cat_Id}")
    void delete(@PathVariable("cat_Id") Long Id);
}
