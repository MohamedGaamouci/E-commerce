package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Gift_with_purchaseDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.Gift_with_purchaseRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.Gift_with_purchaseService;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.Gift_with_purchaseValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Gift_with_purchaseServiceImpl implements Gift_with_purchaseService {
    private final Gift_with_purchaseRepo gift_with_purchaseRepo;

    public Gift_with_purchaseServiceImpl(Gift_with_purchaseRepo gift_with_purchaseRepo) {
        this.gift_with_purchaseRepo = gift_with_purchaseRepo;
    }

    @Override
    public Gift_with_purchaseDto save(Gift_with_purchaseDto dto) {
        List<String> errors = Gift_with_purchaseValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        try {
            return Gift_with_purchaseDto.fromEntity(gift_with_purchaseRepo.save(Gift_with_purchaseDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            gift_with_purchaseRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public Gift_with_purchaseDto findById(Long id) {
        return gift_with_purchaseRepo.findById(id)
                .map(Gift_with_purchaseDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("gift with purchase promotion not found "));
    }

    @Override
    public List<Gift_with_purchaseDto> findAll() {
        return gift_with_purchaseRepo.findAll().stream().map(Gift_with_purchaseDto::fromEntity).collect(Collectors.toList());
    }
}
