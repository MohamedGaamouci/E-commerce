package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;
import com.gmc_team.e_commerse_platform.Repository.DescriptionRepo;
import com.gmc_team.e_commerse_platform.Services.DescriptionService;
import com.gmc_team.e_commerse_platform.Validator.DescriptionsValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DescriptionServiceImpl implements DescriptionService {
    private final DescriptionRepo descriptionRepo;

    @Autowired
    public DescriptionServiceImpl(DescriptionRepo descriptionRepo) {
        this.descriptionRepo = descriptionRepo;
    }

    @Override
    public DescriptionsDto findById(Long Id) {
        return descriptionRepo.findById(Id)
                .map(DescriptionsDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No description with following Id :"+Id
                        , Errorcode.DESCRIPTION_NOT_FOUND_EXCEPTION));
    }

    @Override
    public DescriptionsDto save(DescriptionsDto dto) {
        List<String> errors = DescriptionsValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Description not Valid {}"
                    ,Errorcode.DESCRIPTION_NOT_VALID_EXCEPTION ,errors);
        }
        try {
            return DescriptionsDto.fromEntity(
                descriptionRepo.save(
                        DescriptionsDto.toEntity(dto)
                ));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public List<DescriptionsDto> findAll() {
        return descriptionRepo.findAll()
                .stream().map(DescriptionsDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public List<DescriptionsDto> findByOnline_shopId(Long Id) {
        return descriptionRepo.findAllByOnlineshop(Id)
                .stream().map(DescriptionsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<DescriptionsDto> findByTitle(String title) {
        return descriptionRepo.findAllByTitle(title)
                .stream().map(DescriptionsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long descriptionId) {
        try {
            descriptionRepo.deleteById(descriptionId);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,Errorcode.SQL_STATEMENT_FAILD_OPERATION );
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

}
