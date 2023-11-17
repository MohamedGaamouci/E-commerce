package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.TieredPromotionItemDto;

public interface TieredPromotionItemService {
    TieredPromotionItemDto save (TieredPromotionItemDto dto);
    void delete(Long Id);
    TieredPromotionItemDto findById(Long id);
}
