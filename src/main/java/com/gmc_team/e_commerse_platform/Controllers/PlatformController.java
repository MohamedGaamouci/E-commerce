package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.PlatformApi;
import com.gmc_team.e_commerse_platform.Dto.PlatformDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.PlatformServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatformController implements PlatformApi {

    private final PlatformServiceImpl platformServiceImpl;

    public PlatformController(PlatformServiceImpl platformServiceImpl) {
        this.platformServiceImpl = platformServiceImpl;
    }

    @Override
    public PlatformDto save(PlatformDto dto) {
        return platformServiceImpl.save(dto);
    }

    @Override
    public PlatformDto findById(Long Id) {
        return platformServiceImpl.findById(Id);
    }

    @Override
    public List<PlatformDto> findAll() {
        return platformServiceImpl.findAll();
    }

    @Override
    public PlatformDto AddAdminToThePlatform(Long Id) {
        return platformServiceImpl.AddAdminToThePlatform(Id);
    }

    @Override
    public void deleteAdmin(Long Id) {
        platformServiceImpl.deleteAdmin(Id);
    }
}
