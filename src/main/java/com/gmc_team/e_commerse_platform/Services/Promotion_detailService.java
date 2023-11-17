package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Promotion_detailDto;

public interface Promotion_detailService {
    Promotion_detailDto save(Promotion_detailDto dto);
    Promotion_detailDto findById(Long id);
    void delete(Promotion_detailDto dto);
}
