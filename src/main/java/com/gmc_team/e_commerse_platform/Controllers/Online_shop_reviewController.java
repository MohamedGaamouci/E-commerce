package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Online_shop_reviewApi;
import com.gmc_team.e_commerse_platform.Dto.Online_shop_reviewDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Online_shop_reviewServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Online_shop_reviewController implements Online_shop_reviewApi {
    private final Online_shop_reviewServiceImpl online_shop_reviewServiceImpl;

    public Online_shop_reviewController(Online_shop_reviewServiceImpl online_shop_reviewServiceImpl) {
        this.online_shop_reviewServiceImpl = online_shop_reviewServiceImpl;
    }

    @Override
    public Online_shop_reviewDto findById(Long Id) {
        return online_shop_reviewServiceImpl.findById(Id);
    }

    @Override
    public Online_shop_reviewDto save(Online_shop_reviewDto Id) {
        return online_shop_reviewServiceImpl.save(Id);
    }

    @Override
    public Online_shop_reviewDto findByCustomerId(Long Id) {
        return online_shop_reviewServiceImpl.findByCustomerId(Id);
    }

    @Override
    public List<Online_shop_reviewDto> findByOnline_shopId(Long Id) {
        return online_shop_reviewServiceImpl.findByOnline_shopId(Id);
    }

    @Override
    public Online_shop_reviewDto findByCustomerIdAndOnline_shopId(Long CustomerId, Long StoreId) {
        return online_shop_reviewServiceImpl.findByCustomerIdAndOnline_shopId(CustomerId ,StoreId);
    }
}
