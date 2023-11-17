package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.num_product_conditionDto;

public interface num_product_conditionService {
    num_product_conditionDto save (num_product_conditionDto dto);
    void delete(Long Id);
    num_product_conditionDto findById(Long id);
}
