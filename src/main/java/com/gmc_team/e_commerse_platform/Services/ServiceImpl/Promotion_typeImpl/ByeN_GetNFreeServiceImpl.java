package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.ProductDto;
import com.gmc_team.e_commerse_platform.Dto.promotion_types.ByeN_GetNFreeDto;
import com.gmc_team.e_commerse_platform.Repository.ProductRepo;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.ByeN_GetNFreeRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.ByeN_GetNFreeService;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Online_shopServiceImpl;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.ByeN_GetNFreeValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.PRODCUT_NOT_FOUND_EXCEPTION;

@Service
@Transactional
public class ByeN_GetNFreeServiceImpl implements ByeN_GetNFreeService {
    private final ByeN_GetNFreeRepo byeN_GetNFreeRepo;
    private final ProductRepo productRepo;
    private final Online_shopServiceImpl online_shopServiceImpl;

    public ByeN_GetNFreeServiceImpl(ByeN_GetNFreeRepo byeN_GetNFreeRepo, ProductRepo productRepo, Online_shopServiceImpl online_shopServiceImpl) {
        this.byeN_GetNFreeRepo = byeN_GetNFreeRepo;
        this.productRepo = productRepo;
        this.online_shopServiceImpl = online_shopServiceImpl;
    }

    @Override
    public ByeN_GetNFreeDto save(ByeN_GetNFreeDto dto) {
        List<String> errors = ByeN_GetNFreeValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        online_shopServiceImpl.findById(dto.getOnlineshopid());
        dto.getTargetproduct().forEach(i->findproductById(i));
        try {
            return ByeN_GetNFreeDto.fromEntity(byeN_GetNFreeRepo.save(ByeN_GetNFreeDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            byeN_GetNFreeRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public ByeN_GetNFreeDto findById(Long id) {
        return byeN_GetNFreeRepo.findById(id)
                .map(ByeN_GetNFreeDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("promotion Detail not found "));
    }

    @Override
    public List<ByeN_GetNFreeDto> findAll() {
        return byeN_GetNFreeRepo.findAll()
                .stream().map(ByeN_GetNFreeDto::fromEntity)
                .collect(Collectors.toList());
    }

    public ProductDto findproductById(Long Id) {
        return productRepo.findById(Id).map(val->ProductDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No Product found with ID:"
                        +Id ,PRODCUT_NOT_FOUND_EXCEPTION));
    }
}
