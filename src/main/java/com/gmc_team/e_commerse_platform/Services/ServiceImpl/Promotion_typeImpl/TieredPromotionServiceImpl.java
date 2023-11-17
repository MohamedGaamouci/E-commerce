package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.TieredPromotionDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.TieredPromotionRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.TieredPromotionService;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.TieredPromotionValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TieredPromotionServiceImpl implements TieredPromotionService {
    private final TieredPromotionRepo tieredPromotionRepo;

    public TieredPromotionServiceImpl(TieredPromotionRepo tieredPromotionRepo) {
        this.tieredPromotionRepo = tieredPromotionRepo;
    }

    @Override
    public TieredPromotionDto save(TieredPromotionDto dto) {
        List<String> errors = TieredPromotionValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        try {
            return TieredPromotionDto.fromEntity(tieredPromotionRepo.save(TieredPromotionDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            tieredPromotionRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public TieredPromotionDto findById(Long id) {
        return tieredPromotionRepo.findById(id)
                .map(TieredPromotionDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Tiered promotion not found "));
    }

    @Override
    public List<TieredPromotionDto> findAll() {
        return tieredPromotionRepo.findAll().stream().map(TieredPromotionDto::fromEntity).collect(Collectors.toList());
    }
}
