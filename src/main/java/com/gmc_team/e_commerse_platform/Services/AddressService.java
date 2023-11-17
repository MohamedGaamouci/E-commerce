package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.AddressDto;

public interface AddressService {
    AddressDto save(AddressDto dto);
    AddressDto findById(Long Id);

}
