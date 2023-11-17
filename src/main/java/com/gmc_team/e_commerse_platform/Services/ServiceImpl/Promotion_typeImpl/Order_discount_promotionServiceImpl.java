package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Order_discount_promotionDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.Order_discount_promotionRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.Order_discount_promotionService;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Online_shopServiceImpl;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.Order_discount_promotionValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Order_discount_promotionServiceImpl implements Order_discount_promotionService {
    private final Order_discount_promotionRepo order_discount_promotionRepo;
    private final Online_shopServiceImpl online_shopServiceImpl;

    public Order_discount_promotionServiceImpl(Order_discount_promotionRepo order_discount_promotionRepo, Online_shopServiceImpl online_shopServiceImpl) {
        this.order_discount_promotionRepo = order_discount_promotionRepo;
        this.online_shopServiceImpl = online_shopServiceImpl;
    }

    @Override
    public Order_discount_promotionDto save(Order_discount_promotionDto dto) {
        List<String> errors = Order_discount_promotionValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        online_shopServiceImpl.findById(dto.getOnlineshopid());
        try {
            return Order_discount_promotionDto.fromEntity(order_discount_promotionRepo.save(Order_discount_promotionDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            order_discount_promotionRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public Order_discount_promotionDto findById(Long id) {
        return order_discount_promotionRepo.findById(id)
                .map(Order_discount_promotionDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("discount promotion not found"));
    }

    @Override
    public List<Order_discount_promotionDto> findAll() {
        return order_discount_promotionRepo.findAll().stream().map(Order_discount_promotionDto::fromEntity)
                .collect(Collectors.toList());
    }
}
