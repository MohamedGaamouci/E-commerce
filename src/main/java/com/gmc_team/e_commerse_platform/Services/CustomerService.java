package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.CustomersDto;
import com.gmc_team.e_commerse_platform.Dto.ProductDto;
import com.gmc_team.e_commerse_platform.models.Roles;

import java.util.List;

public interface CustomerService {
    CustomersDto findById(Long Id);
    CustomersDto save(CustomersDto dto);
    CustomersDto findByUserName(String username);
    List<CustomersDto> findAll();
    List<CustomersDto> findByNameAndSecondName(String Name ,String SecondName);
    CustomersDto findByEmail(String Email);
    List<CustomersDto> findByGender(String gender);
    List<CustomersDto> findByRole(List<Roles> rolesName);
    List<ProductDto> findAllFavorite(Long customerId);

}
