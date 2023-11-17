package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Loyalty_programsDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.Loyalty_programsRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.Loyalty_programsService;
import com.gmc_team.e_commerse_platform.exceptions.Errorcode;
import com.gmc_team.e_commerse_platform.exceptions.InvalidDataBaseOperationException;
import com.gmc_team.e_commerse_platform.exceptions.InvalidOperationException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Loyalty_programsServiceImpl implements Loyalty_programsService {
    private final Loyalty_programsRepo loyalty_programsRepo;

    public Loyalty_programsServiceImpl(Loyalty_programsRepo loyalty_programsRepo) {
        this.loyalty_programsRepo = loyalty_programsRepo;
    }

    @Override
    public Loyalty_programsDto save(Loyalty_programsDto dto) {
//        List<String> errors = Loyalty_programsValidator.validate(dto);
//        if (!errors.isEmpty()){
//            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
//        }
//        try {
//            return Loyalty_programsDto.fromEntity(loyalty_programsRepo.save(Loyalty_programsDto.toEntity(dto)));
//        }catch (DataAccessException ex){
//            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
//        }catch (Exception e){
//            throw new InvalidOperationException(e.getMessage());
//        }
        return null;
    }

    @Override
    public void delete(Long Id) {
        try {
            loyalty_programsRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
}
