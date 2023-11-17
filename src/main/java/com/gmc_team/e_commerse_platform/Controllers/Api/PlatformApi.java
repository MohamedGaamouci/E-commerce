package com.gmc_team.e_commerse_platform.Controllers.Api;


import com.gmc_team.e_commerse_platform.Dto.PlatformDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api("Platform")
public interface PlatformApi {
    @PostMapping(value = "/Platform/save" ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces =MediaType.APPLICATION_JSON_VALUE)
    PlatformDto save (@RequestBody PlatformDto dto);
    @GetMapping(value = "/Platform/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    PlatformDto findById (@PathVariable Long Id);
    @GetMapping(value = "/Platform/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<PlatformDto> findAll ();

    @GetMapping(value = "/Platform/AddAdminToThePlatform/{AdminId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public PlatformDto AddAdminToThePlatform(@PathVariable("AdminId") Long Id);

    @DeleteMapping(value = "/Platform/deleteAdmin/{AdminId}")
    public void deleteAdmin(@PathVariable("AdminId") Long Id);
}
