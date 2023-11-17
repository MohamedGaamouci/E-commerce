package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.PromotionDto;

public interface PromotionService {
    PromotionDto save (PromotionDto dto);
    void delete(Long Id);
}
