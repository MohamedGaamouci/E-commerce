package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.Promotion_detailDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_detailRepository;
import com.gmc_team.e_commerse_platform.Services.Promotion_detailService;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl.*;
import com.gmc_team.e_commerse_platform.Validator.Promotion_detailValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.promotion_types.Promotion_Type;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Promotion_detailServiceImpl implements Promotion_detailService {
    private final Promotion_detailRepository promotion_detailRepository;
    private final ByeN_GetNFreeServiceImpl byeN_GetNFreeServiceImpl;
    private final Percentage_discountsServiceImpl percentage_discountsServiceImpl;
    private final TieredPromotionItemServiceImpl tieredPromotionItemServiceImpl;

    public Promotion_detailServiceImpl(Promotion_detailRepository promotion_detailRepository,
                                       ByeN_GetNFreeServiceImpl byeN_GetNFreeServiceImpl,
                                       Percentage_discountsServiceImpl percentage_discountsServiceImpl,
                                       TieredPromotionItemServiceImpl tieredPromotionItemServiceImpl) {
        this.promotion_detailRepository = promotion_detailRepository;
        this.byeN_GetNFreeServiceImpl = byeN_GetNFreeServiceImpl;
        this.percentage_discountsServiceImpl = percentage_discountsServiceImpl;
        this.tieredPromotionItemServiceImpl = tieredPromotionItemServiceImpl;
    }

    @Override
    public Promotion_detailDto save(Promotion_detailDto dto) {
        List<String> errors = Promotion_detailValidator.Validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion Detail not Valid {}" ,errors);
        }
        if (dto.getId()!=null){
            findById(dto.getId());
        }
        if (dto.getType().equals(Promotion_Type.product_discount)){
            percentage_discountsServiceImpl.findById(dto.getPromotion());
        }
        else if (dto.getType().equals(Promotion_Type.bye_n_take_n)){
            byeN_GetNFreeServiceImpl.findById(dto.getPromotion());
        }
        else if (dto.getType().equals(Promotion_Type.tiered_promotion)){
            tieredPromotionItemServiceImpl.findById(dto.getPromotion());
        }
        else{
            throw new InvalidOperationException("The promotion not compatible with the target product");
        }
        try {
            return Promotion_detailDto.fromEntity(promotion_detailRepository.save(Promotion_detailDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public Promotion_detailDto findById(Long id) {
        return promotion_detailRepository.findById(id)
                .map(Promotion_detailDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("promotion Detail not found "));
    }

    @Override
    public void delete(Promotion_detailDto dto) {
        try {
            promotion_detailRepository.delete(Promotion_detailDto.toEntity(dto));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
}
