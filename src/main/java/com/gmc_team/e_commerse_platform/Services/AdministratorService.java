package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.AdministratorsDto;

import java.util.List;

public interface AdministratorService {
    AdministratorsDto save(AdministratorsDto dto);
    AdministratorsDto findById(Long Id);
    AdministratorsDto findByUserName(String username);
    List<AdministratorsDto> findAll();
    List<AdministratorsDto> findByfirstNameAndSecondName(String firstName ,String SecondName);
    AdministratorsDto findByEmail(String Email);
    Boolean UserNameExist(String username);
    void delete(Long Id);



}
