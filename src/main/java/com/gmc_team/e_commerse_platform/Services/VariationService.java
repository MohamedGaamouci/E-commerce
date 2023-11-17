package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.VariationDto;

import java.util.List;

public interface VariationService {
    VariationDto findById(Long Id);
    VariationDto save(VariationDto dto);
    VariationDto findByName(String Name);
    List<VariationDto> findAll();
    void delete(Long varId);
}
