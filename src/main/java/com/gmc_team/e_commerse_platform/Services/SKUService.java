package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.SKUDto;

import java.util.List;

public interface SKUService {
    SKUDto findById(Long Id);
    SKUDto save(SKUDto dto);
    SKUDto findByName(String Name);
    List<SKUDto> findByNameStartwith(String Name);
    List<SKUDto> findByNameContaining(String Name);
    void delete(Long skuId);

    List<SKUDto> findAll();
}
