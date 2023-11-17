package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.SKUDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SKUApi {
    @GetMapping(value = "/SKU/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    SKUDto findById(@PathVariable("Id") Long Id);


    @PostMapping(value = "/SKU/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    SKUDto save(@RequestBody SKUDto dto);


    @GetMapping(value = "/SKU/findByName/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    SKUDto findByName(@PathVariable("Name") String Name);


    @GetMapping(value = "/SKU/findByNameStartwith/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<SKUDto> findByNameStartwith(@PathVariable("Name")String Name);

    @GetMapping(value = "/SKU/findByNameContaining/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<SKUDto> findByNameContaining(@PathVariable("Name")String Name);

    @GetMapping(value = "/SKU/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<SKUDto> findAll();


    @DeleteMapping(value = "/SKU/delete/{SKU_Id}" )
    void delete( @PathVariable("SKU_Id") Long SKU_Id);
}
