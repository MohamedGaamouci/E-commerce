package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.PlatformDto;

import java.util.List;

public interface PlatformService {
    PlatformDto save (PlatformDto dto);
    PlatformDto findById (Long Id);
    PlatformDto AddAdminToThePlatform (Long Id);
    List<PlatformDto> findAll ();
    void deleteAdmin(Long id);
}
