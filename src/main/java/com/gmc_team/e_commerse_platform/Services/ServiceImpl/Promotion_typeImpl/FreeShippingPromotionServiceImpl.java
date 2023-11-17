package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.FreeShippingPromotionDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.FreeShippingPromotionRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.FreeShippingPromotionService;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.FreeShippingPromotionValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class FreeShippingPromotionServiceImpl implements FreeShippingPromotionService {
    private final FreeShippingPromotionRepo freeShippingPromotionRepo;

    public FreeShippingPromotionServiceImpl(FreeShippingPromotionRepo freeShippingPromotionRepo) {
        this.freeShippingPromotionRepo = freeShippingPromotionRepo;
    }

    @Override
    public FreeShippingPromotionDto save(FreeShippingPromotionDto dto) {
        List<String> errors = FreeShippingPromotionValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        try {
            return FreeShippingPromotionDto.fromEntity(freeShippingPromotionRepo.save(FreeShippingPromotionDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            freeShippingPromotionRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public FreeShippingPromotionDto findById(Long id) {
        return freeShippingPromotionRepo.findById(id)
                .map(FreeShippingPromotionDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("promotion Detail not found "));
    }

    @Override
    public List<FreeShippingPromotionDto> findAll() {
        return freeShippingPromotionRepo.findAll().stream().map(FreeShippingPromotionDto::fromEntity).collect(Collectors.toList());
    }
}
