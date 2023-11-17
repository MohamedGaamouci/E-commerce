package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.GiftDto;

import java.util.List;

public interface GiftService {
    GiftDto save (GiftDto dto);
    void delete(Long Id);
    GiftDto findById(Long id);

    List<GiftDto> findAll();
}
