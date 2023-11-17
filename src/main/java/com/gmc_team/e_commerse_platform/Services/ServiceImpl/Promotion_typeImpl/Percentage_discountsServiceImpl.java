package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Percentage_discountsDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.Percentage_discountsRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.Percentage_discountsService;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.Percentage_discountsValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Percentage_discountsServiceImpl implements Percentage_discountsService {
    private final Percentage_discountsRepo percentage_discountsRepo;

    public Percentage_discountsServiceImpl(Percentage_discountsRepo percentage_discountsRepo) {
        this.percentage_discountsRepo = percentage_discountsRepo;
    }

    @Override
    public Percentage_discountsDto save(Percentage_discountsDto dto) {
        List<String> errors = Percentage_discountsValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        try {
            return Percentage_discountsDto.fromEntity(percentage_discountsRepo.save(Percentage_discountsDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            percentage_discountsRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public Percentage_discountsDto findById(Long id) {
        return percentage_discountsRepo.findById(id)
                .map(Percentage_discountsDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("percentage promotion not found "));
    }

    @Override
    public List<Percentage_discountsDto> findAll() {
        return percentage_discountsRepo.findAll().stream().map(Percentage_discountsDto::fromEntity).collect(Collectors.toList());
    }
}
