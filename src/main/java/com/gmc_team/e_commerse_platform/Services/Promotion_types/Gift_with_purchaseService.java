package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Gift_with_purchaseDto;

import java.util.List;

public interface Gift_with_purchaseService {
    Gift_with_purchaseDto save (Gift_with_purchaseDto dto);
    void delete(Long Id);
    Gift_with_purchaseDto findById(Long id);

    List<Gift_with_purchaseDto> findAll();
}
