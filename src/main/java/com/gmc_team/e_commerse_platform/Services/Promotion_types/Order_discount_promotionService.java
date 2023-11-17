package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Order_discount_promotionDto;

import java.util.List;

public interface Order_discount_promotionService {
    Order_discount_promotionDto save (Order_discount_promotionDto dto);
    void delete(Long Id);
    Order_discount_promotionDto findById(Long id);

    List<Order_discount_promotionDto> findAll();
}
