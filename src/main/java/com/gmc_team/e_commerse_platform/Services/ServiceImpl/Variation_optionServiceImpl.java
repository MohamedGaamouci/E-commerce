package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.VariationDto;
import com.gmc_team.e_commerse_platform.Dto.Variation_optionDto;
import com.gmc_team.e_commerse_platform.Repository.Variation_optionRepo;
import com.gmc_team.e_commerse_platform.Services.Variation_optionService;
import com.gmc_team.e_commerse_platform.Validator.Variation_optionValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Variation;
import com.gmc_team.e_commerse_platform.models.Variation_option;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Variation_optionServiceImpl implements Variation_optionService {
    private final Variation_optionRepo variation_optionRepo;
    private final VariationServiceImpl variationServiceImpl;

    public Variation_optionServiceImpl(Variation_optionRepo variation_optionRepo, VariationServiceImpl variationServiceImpl) {
        this.variation_optionRepo = variation_optionRepo;
        this.variationServiceImpl = variationServiceImpl;
    }

    @Override
    public Variation_optionDto findById(Long Id) {
        return variation_optionRepo.findById(Id)
                .map(var->Variation_optionDto.fromEntity(var ,true))
                .orElseThrow(()->new EntityNotFoundException("Variation Option Not found ",
                        Errorcode.VARIATION_NOT_FOUND_EXCEPTION));
    }

    @Override
    public Variation_optionDto save(Variation_optionDto dto) {
        List<String > errors = Variation_optionValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Variation option Not Valid {}" ,
                    Errorcode.VARIATION_NOT_VALID_EXCEPTION ,errors);
        }
        VariationDto variationDto = variationServiceImpl.findById(dto.getVariation().getId());
        Variation_option var = variation_optionRepo
                .findByOptionvalueAndVariation(dto.getOption_value(),VariationDto.toEntity(variationDto));
        if(var !=null){
            throw new InvalidOperationException(
                    dto.getOption_value()+" Already in exist in the variation '"+variationDto.getName()+"'",
                    Errorcode.VARIATION_OPTION_NOT_VALID_EXCEPTION);
        }
        Variation_optionDto optionDto=Variation_optionDto.fromEntity(
                variation_optionRepo.save(Variation_optionDto.toEntity(dto)) ,true
        );
        List<Variation_optionDto> list = variationDto.getVariation_optionDtos();
        list.add(optionDto);
        variationDto.setVariation_optionDtos(list);
        try {
            variationServiceImpl.save(variationDto);

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
        return optionDto;
    }

    @Override
    public List<Variation_optionDto> findByVariationId(Long Id) {
        VariationDto dto = variationServiceImpl.findById(Id);
        return variation_optionRepo.findAllByVariation(VariationDto.toEntity(dto))
                .stream()
                .map(var->Variation_optionDto.fromEntity(var ,true))
                .collect(Collectors.toList());
    }

    @Override
    public Variation_optionDto findByOption_value(String option_value ,Long VariationOptionId) {
        Variation dto = VariationDto.toEntity(variationServiceImpl.findById(VariationOptionId));

        return Variation_optionDto
                .fromEntity(variation_optionRepo.findByOptionvalueAndVariation(option_value,dto),true);

    }

    @Override
    public void delete(Long varId) {
        try {
            Variation_optionDto optionDto = findById(varId);
            optionDto.setVariation(null);
            save(optionDto);
            variation_optionRepo.deleteById(varId);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception ex){
            throw new InvalidOperationException(ex.getMessage());
        }
    }
}
