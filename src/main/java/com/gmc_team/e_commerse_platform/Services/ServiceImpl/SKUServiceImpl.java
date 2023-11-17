package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.SKUDto;
import com.gmc_team.e_commerse_platform.Repository.SKURepo;
import com.gmc_team.e_commerse_platform.Services.SKUService;
import com.gmc_team.e_commerse_platform.Validator.SKUValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.SKU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SKUServiceImpl implements SKUService {
    private final SKURepo SkuRepo;

    @Autowired
    public SKUServiceImpl(SKURepo SkuRepo) {
        this.SkuRepo = SkuRepo;
    }

    @Override
    public SKUDto findById(Long Id) {
        return SkuRepo.findById(Id)
                .map(SKUDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No sku found with the following Id:"+Id,
                        Errorcode.SKU_NOT_FOUND_EXCEPTION));
    }

    @Override
    public SKUDto save(SKUDto dto) {
        List<String> errors = SKUValidator.validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("the SKU not Valid{}"
            ,Errorcode.SKY_NOT_VALID_EXCEPTION,errors);
        }
        SKU sku = SkuRepo.findByNameEqualsIgnoreCase(dto.getName());
        if(sku != null && dto.getId() ==null){
            throw new InvalidOperationException(dto.getName()+":: is already exist" );
        }
        try {
            return SKUDto.fromEntity(SkuRepo.save(SKUDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public SKUDto findByName(String Name) {
        SKU sku = SkuRepo.findByNameEqualsIgnoreCase(Name);
        if(sku == null){
            throw new InvalidOperationException("No SKU with the following Name:"+Name);
        }
        return SKUDto.fromEntity(sku);
    }

    @Override
    public List<SKUDto> findByNameStartwith(String Name) {
        return SkuRepo.findByNameStartingWith(Name)
                .stream().map(SKUDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SKUDto> findByNameContaining(String Name) {
        return SkuRepo.findByNameContainingIgnoreCase(Name)
                .stream().map(SKUDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long skuId) {
        try {
            SkuRepo.deleteById(skuId);

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage(), Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception ex){
            throw new InvalidOperationException(ex.getMessage());
        }
    }

    @Override
    public List<SKUDto> findAll() {
        return SkuRepo.findAll().stream()
                .map(SKUDto::fromEntity)
                .collect(Collectors.toList());
    }
}
