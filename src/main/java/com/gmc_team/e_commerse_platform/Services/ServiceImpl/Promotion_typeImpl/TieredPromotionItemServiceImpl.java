package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.TieredPromotionItemDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.TieredPromotionItemRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.TieredPromotionItemService;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.TieredPromotionItemValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TieredPromotionItemServiceImpl implements TieredPromotionItemService {
    private final TieredPromotionItemRepo tieredPromotionItemRepo;

    public TieredPromotionItemServiceImpl(TieredPromotionItemRepo tieredPromotionItemRepo) {
        this.tieredPromotionItemRepo = tieredPromotionItemRepo;
    }

    @Override
    public TieredPromotionItemDto save(TieredPromotionItemDto dto) {
        List<String> errors = TieredPromotionItemValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        try {
            return TieredPromotionItemDto.fromEntity(tieredPromotionItemRepo.save(TieredPromotionItemDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            tieredPromotionItemRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public TieredPromotionItemDto findById(Long id) {
        return tieredPromotionItemRepo.findById(id)
                .map(TieredPromotionItemDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("tiered promotion not found "));
    }
}
