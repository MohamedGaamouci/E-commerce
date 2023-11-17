package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.SellersDto;
import com.gmc_team.e_commerse_platform.models.Roles;

import java.util.List;

public interface SellerService {
    SellersDto findById(Long Id);
    SellersDto save(SellersDto dto);

    List<SellersDto> findAll();
    List<SellersDto> findByfirstNameAndSecondName(String firstName , String SecondName);
    SellersDto findByUserName(String username);
    SellersDto findByEmail(String Email);
    List<SellersDto> findByGender(String gender);
    List<SellersDto> findByRole(List<Roles> rolesName);

    void disactivate(Long id);
    void activate(Long id);
    void delete(Long id);
}
