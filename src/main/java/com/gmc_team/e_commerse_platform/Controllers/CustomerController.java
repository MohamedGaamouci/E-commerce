package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.CustomerApi;
import com.gmc_team.e_commerse_platform.Dto.CustomersDto;
import com.gmc_team.e_commerse_platform.Dto.ProductDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.CustomerServiceImpl;
import com.gmc_team.e_commerse_platform.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomerApi {


    private final CustomerServiceImpl service;
    @Autowired
    public CustomerController(CustomerServiceImpl service) {
        this.service = service;
    }

    @Override
    public CustomersDto findById(Long Id) {
        return service.findById(Id);
    }

    @Override
    public CustomersDto save(CustomersDto dto) {
        return service.save(dto);
    }

    @Override
    public CustomersDto findByUserName(String username) {
        return service.findByUserName(username);
    }

    @Override
    public List<CustomersDto> findAll() {
        return service.findAll();
    }

    @Override
    public List<CustomersDto> findByNameAndSecondName(String Name, String SecondName) {
        return service.findByNameAndSecondName(Name ,SecondName);
    }

    @Override
    public CustomersDto findByEmail(String Email) {
        return service.findByEmail(Email);
    }

    @Override
    public List<CustomersDto> findByGender(String gender) {
        return service.findByGender(gender);
    }

    @Override
    public List<CustomersDto> findByRole(List<Roles> rolesName) {
        return service.findByRole(rolesName);
    }
    @Override
    public List<ProductDto> findAllFavorite(Long customerId){
        return service.findAllFavorite(customerId);
    }

    @Override
    public void delete(Long Id) {
        service.delete(Id);
    }



}
