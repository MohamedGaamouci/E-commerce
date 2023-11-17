package com.gmc_team.e_commerse_platform.Services.Promotion_types;


import com.gmc_team.e_commerse_platform.Dto.promotion_types.FreeShippingPromotionDto;

import java.util.List;

public interface FreeShippingPromotionService {
    FreeShippingPromotionDto save (FreeShippingPromotionDto dto);
    void delete(Long Id);
    FreeShippingPromotionDto findById(Long id);

    List<FreeShippingPromotionDto> findAll();
}
