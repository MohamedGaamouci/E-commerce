package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.TieredPromotionDto;

import java.util.List;

public interface TieredPromotionService {

    TieredPromotionDto save (TieredPromotionDto dto);
    void delete(Long Id);
    TieredPromotionDto findById(Long id);

    List<TieredPromotionDto> findAll();
}
