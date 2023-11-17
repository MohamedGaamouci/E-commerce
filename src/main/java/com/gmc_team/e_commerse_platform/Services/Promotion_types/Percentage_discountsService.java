package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Percentage_discountsDto;

import java.util.List;

public interface Percentage_discountsService {
    Percentage_discountsDto save (Percentage_discountsDto dto);
    void delete(Long Id);
    Percentage_discountsDto findById(Long id);

    List<Percentage_discountsDto> findAll();
}
