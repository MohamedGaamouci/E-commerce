package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Delevery_time_detailDto;

public interface Delevery_time_detailService {
    Delevery_time_detailDto findById(Long Id);
    Delevery_time_detailDto save(Delevery_time_detailDto Id);
    void delete(Long Id);
}
