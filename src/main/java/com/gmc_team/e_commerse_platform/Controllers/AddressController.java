package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.AddressApi;
import com.gmc_team.e_commerse_platform.Dto.AddressDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.AddressServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AddressController implements AddressApi {

    AddressServiceImpl addressService;

    @Autowired
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }


    @Override
    public AddressDto save(AddressDto dto) {
        log.info("enter address save method");
        return addressService.save(dto);
    }

    @Override
    public AddressDto findBYId(Long Id) {
        log.info("enter address find method");
        return addressService.findById(Id);
    }

    @Override
    public Boolean IsPhoneNumberUsed(Long num) {
        return addressService.IsPhoneNumberUsed(num);
    }

}
