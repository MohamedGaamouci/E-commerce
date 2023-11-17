package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.AdministratorsDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Administrator")
public interface AdministratorApi {

//    @ApiOperation(value = "save a Administrator /modify", response = Administrators.class ,httpMethod = "POST"
//            ,notes ="in the modify case put the Id in the Json Object ,the save case without id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrator Object saved/modified successfully"),
//            @ApiResponse(code = 400, message = "The Administrator Object Not Valid")
//    })
    @PostMapping(value = "/Administrator/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    AdministratorsDto save(@RequestBody AdministratorsDto dto);

//    @ApiOperation(value = "Get a Administrator with an id", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrator Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Administrator Object Not Found")
//    })
    @GetMapping(value = "/Administrator/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    AdministratorsDto findById(@PathVariable("Id") Long Id);

//    @ApiOperation(value = "Get a Administrator with an Email", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrator Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Administrator Object Not Found")
//    })
    @GetMapping(value = "/Administrator/findByEmail/{Email}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    AdministratorsDto findByEmail(@PathVariable("Email") String Email);

//    @ApiOperation(value = "Get a Administrator with an user name", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrator Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Administrator Object Not Found")
//    })
    @GetMapping(value = "/Administrator/findByUserName/{UserName}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    AdministratorsDto findByUserName(@PathVariable("UserName") String UserName);

//    @ApiOperation(value = "Get all the Administrators", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrators Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Administrators Object Not Found")
//    })
    @GetMapping(value = "/Administrator/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<AdministratorsDto> findAll();

//    @ApiOperation(value = "Get a Administrator with an first name && second name", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrator Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Administrator Object Not Found")
//    })
    @GetMapping(value = "/Administrator/findByFN_SN" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<AdministratorsDto> findByfirstNameAndSecondName(@RequestParam String firstName,@RequestParam String secondName);

//    @ApiOperation(value = "Administrator exist or not ( True/ false) by username ", response = Administrators.class ,httpMethod = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrator Object Got successfully"),
//            @ApiResponse(code = 400, message = "The Administrator Object Not Found")
//    })
    @GetMapping("/Administrator/UserName_Exist/{UserName}")
    Boolean UserNameExist(@PathVariable("UserName") String UserName);

//    @ApiOperation(value = "delete a Administrator with an id ",response = Administrators.class ,httpMethod = "DELETE")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Administrators Object deleted successfully"),
//            @ApiResponse(code = 400, message = "The Administrators Object Not Found / or already in use")
//    })
    @DeleteMapping("/Administrator/delete/{Admin_Id}")
    void delete(@PathVariable("Admin_Id") Long UserName);

}
