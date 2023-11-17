package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.ByeN_GetNFreeDto;

import java.util.List;

public interface ByeN_GetNFreeService {

    ByeN_GetNFreeDto save (ByeN_GetNFreeDto dto);
    void delete(Long Id);
    ByeN_GetNFreeDto findById(Long id);

    List<ByeN_GetNFreeDto> findAll();
}
