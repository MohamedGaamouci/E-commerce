package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.Delevery_time_detailDto;
import com.gmc_team.e_commerse_platform.Repository.Delevery_time_detailRepo;
import com.gmc_team.e_commerse_platform.Services.Delevery_time_detailService;
import com.gmc_team.e_commerse_platform.Validator.Delevery_time_detailValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Delevery_time_detailServiceImpl implements Delevery_time_detailService {
    private final Delevery_time_detailRepo delevery_time_detailRepo;

    public Delevery_time_detailServiceImpl(Delevery_time_detailRepo delevery_time_detailRepo) {
        this.delevery_time_detailRepo = delevery_time_detailRepo;
    }

    @Override
    public Delevery_time_detailDto findById(Long Id) {
        return delevery_time_detailRepo.findById(Id)
                .map(Delevery_time_detailDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Shipping Method with the following Id :"+Id, Errorcode.SHIPPING_DETAIL_SELLER_NOT_FOUND));
    }

    @Override
    public Delevery_time_detailDto save(Delevery_time_detailDto dto) {
        List<String> errors = Delevery_time_detailValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Delvery time details not Valid{}"
                    ,Errorcode.SHIPPING_DETAIL_SELLER_NOT_VALID,errors);
        }
        try {

        return Delevery_time_detailDto.fromEntity(
                delevery_time_detailRepo.save(Delevery_time_detailDto.toEntity(dto))
        );
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {

    }
}
