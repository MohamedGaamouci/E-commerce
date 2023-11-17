package com.gmc_team.e_commerse_platform.Controllers.Api;


import com.gmc_team.e_commerse_platform.Dto.Variation_optionDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("/Variation_option")
public interface Variation_optionApi {
    @GetMapping(value = "/Variation_option/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Variation_optionDto findById(@PathVariable("Id") Long Id);


    @PostMapping(value = "/Variation_option/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    Variation_optionDto save(@RequestBody Variation_optionDto dto);
    @GetMapping(value = "/Variation_option/findByVariationId/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<Variation_optionDto> findByVariationId(@PathVariable("Id") Long Id);

    @GetMapping(value = "/Variation_option/findByOption_value" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Variation_optionDto findByOption_value(@RequestParam("option") String option_value
            ,@RequestParam("variationId") Long VariationId);

    @DeleteMapping(value = "/Variation_option/delete/{Var_Id}" )
    void delete( @PathVariable("Var_Id") Long Var_Id);
}
