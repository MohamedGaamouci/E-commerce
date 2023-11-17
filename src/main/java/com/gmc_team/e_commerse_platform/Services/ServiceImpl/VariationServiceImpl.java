package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.VariationDto;
import com.gmc_team.e_commerse_platform.Repository.VariationRepo;
import com.gmc_team.e_commerse_platform.Services.VariationService;
import com.gmc_team.e_commerse_platform.Validator.VariationValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VariationServiceImpl implements VariationService {
    private final VariationRepo variationRepo;

    @Autowired
    public VariationServiceImpl(VariationRepo variationRepo) {
        this.variationRepo = variationRepo;
    }

    @Override
    public VariationDto findById(Long Id) {
        return variationRepo.findById(Id)
                .map(Var->VariationDto.fromEntity(Var ,true))
                .orElseThrow(()->new EntityNotFoundException("Variation Not found ",
                        Errorcode.VARIATION_NOT_FOUND_EXCEPTION));
    }

    @Override
    public VariationDto save(VariationDto dto) {
        List<String > errors = VariationValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Variation Not Valid {}" ,
                    Errorcode.VARIATION_NOT_VALID_EXCEPTION ,errors);
        }
        if(findByName(dto.getName())!=null && dto.getId() == null) throw new InvalidOperationException("this Variation name already in use "+dto.getName());
        try {
            return VariationDto.fromEntity(
                variationRepo.save(VariationDto.toEntity(dto) ),true
        );

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public VariationDto findByName(String Name) {
        return VariationDto.fromEntity(
                variationRepo.findByName(Name) ,true
        );
    }

    @Override
    public List<VariationDto> findAll() {
        return variationRepo.findAll().stream()
                .map(var -> VariationDto.fromEntity(var ,true))
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Long varId) {
        try {
            variationRepo.deleteById(varId);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception ex){
            throw new InvalidOperationException(ex.getMessage());
        }
    }
}
