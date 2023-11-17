package com.gmc_team.e_commerse_platform.Controllers.Api;


import com.gmc_team.e_commerse_platform.Dto.VariationDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Variation")
public interface VariationApi {

    @GetMapping(value = "/Variation/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    VariationDto findById(@PathVariable("Id") Long Id);


    @PostMapping(value = "/Variation/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    VariationDto save(@RequestBody VariationDto dto);

    @GetMapping(value = "/Variation/findByName/{Name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    VariationDto findByName(@PathVariable("Name")String Name);

    @GetMapping(value = "/Variation/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<VariationDto> findByAll();

    @DeleteMapping(value = "/Variation/delete/{Var_Id}" )
    void delete( @PathVariable("Var_Id") Long Var_Id);

}
