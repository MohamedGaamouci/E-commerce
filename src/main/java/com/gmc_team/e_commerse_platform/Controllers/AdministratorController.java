package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.AdministratorApi;
import com.gmc_team.e_commerse_platform.Dto.AdministratorsDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdministratorController implements AdministratorApi {

    private AdministratorServiceImpl service;

    @Autowired
    public AdministratorController(AdministratorServiceImpl service) {
        this.service = service;
    }

    @Override
    public AdministratorsDto save(AdministratorsDto dto) {
        return service.save(dto);
    }

    @Override
    public AdministratorsDto findById(Long Id) {
        return service.findById(Id);
    }

    @Override
    public AdministratorsDto findByEmail(String Email) {
        return service.findByEmail(Email);
    }

    @Override
    public AdministratorsDto findByUserName(String UserName) {
        return service.findByUserName(UserName);
    }

    @Override
    public List<AdministratorsDto> findAll() {
        return service.findAll();
    }

    @Override
    public List<AdministratorsDto> findByfirstNameAndSecondName(String firstName, String SecondName) {
        return service.findByfirstNameAndSecondName(firstName ,SecondName);
    }

    @Override
    public Boolean UserNameExist(String UserName) {
        return service.UserNameExist(UserName);
    }

    @Override
    public void delete(Long Id) {
            service.delete(Id);
    }
}
