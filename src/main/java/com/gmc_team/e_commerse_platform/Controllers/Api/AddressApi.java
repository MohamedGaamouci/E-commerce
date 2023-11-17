package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.AddressDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@Api(value="/Address_Api")
public interface AddressApi {

    @PostMapping(value = "/Address/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    AddressDto save(@RequestBody AddressDto dto);

    @GetMapping(value = "/Address/find_Address/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    AddressDto findBYId(@PathVariable("Id") Long Id);


    @GetMapping(value = "/Address/IsPhoneNumberUsed/{num}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    Boolean IsPhoneNumberUsed(@PathVariable("num") Long num);


}
