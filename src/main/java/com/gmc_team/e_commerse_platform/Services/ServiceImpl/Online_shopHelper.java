package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Repository.Online_shopRepo;
import com.gmc_team.e_commerse_platform.exceptions.EntityNotFoundException;
import com.gmc_team.e_commerse_platform.exceptions.Errorcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Online_shopHelper{
    private final Online_shopRepo online_shopRepo;

    @Autowired
    public Online_shopHelper(Online_shopRepo online_shopRepo) {
        this.online_shopRepo = online_shopRepo;

    }

    public Online_shopDto findById(Long Id) {
        return online_shopRepo.findById(Id)
                .map(val->Online_shopDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No store with the following id ::"+Id ,
                        Errorcode.ONLINE_SHOP_NOT_FOUND_EXCEPTION));
    }

}
