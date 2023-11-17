package com.gmc_team.e_commerse_platform.Services.Promotion_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Loyalty_programsDto;

public interface Loyalty_programsService {
    Loyalty_programsDto save (Loyalty_programsDto dto);
    void delete(Long Id);
}
