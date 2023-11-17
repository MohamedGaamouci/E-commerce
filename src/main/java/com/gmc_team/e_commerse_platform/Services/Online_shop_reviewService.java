package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Online_shop_reviewDto;

import java.util.List;

public interface Online_shop_reviewService {
    Online_shop_reviewDto findById(Long Id);
    Online_shop_reviewDto save(Online_shop_reviewDto Id);
    Online_shop_reviewDto findByCustomerId(Long Id);
    Online_shop_reviewDto findByCustomerIdAndOnline_shopId(Long customer ,Long online);
    List<Online_shop_reviewDto> findByOnline_shopId(Long Id);

}
