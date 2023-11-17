package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.num_product_conditionDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.num_product_conditionRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.num_product_conditionService;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.num_product_conditionValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class num_product_conditionServiceImpl implements num_product_conditionService {
    private final com.gmc_team.e_commerse_platform.Repository.Promotion_types.num_product_conditionRepo num_product_conditionRepo;

    public num_product_conditionServiceImpl(num_product_conditionRepo num_product_conditionRepo) {
        this.num_product_conditionRepo = num_product_conditionRepo;
    }

    @Override
    public num_product_conditionDto save(num_product_conditionDto dto) {
        List<String> errors = num_product_conditionValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        try {
            return num_product_conditionDto.fromEntity(num_product_conditionRepo.save(num_product_conditionDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            num_product_conditionRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public num_product_conditionDto findById(Long id) {
        return num_product_conditionRepo.findById(id)
                .map(num_product_conditionDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("product condition not found "));
    }
}
