package com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl;

import com.gmc_team.e_commerse_platform.Dto.ImagesDto;
import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;
import com.gmc_team.e_commerse_platform.Dto.promotion_types.GiftDto;
import com.gmc_team.e_commerse_platform.Dto.promotion_types.num_product_conditionDto;
import com.gmc_team.e_commerse_platform.Repository.Promotion_types.GiftRepo;
import com.gmc_team.e_commerse_platform.Services.Promotion_types.GiftService;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.ImagesServiceImpl;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Product_itemServiceImpl;
import com.gmc_team.e_commerse_platform.Validator.promotions_types.GiftValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GiftServiceImpl implements GiftService {
    private final GiftRepo giftRepo;
    private final ImagesServiceImpl imagesServiceImpl;
    private final Product_itemServiceImpl product_itemServiceImpl;
    private final com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl.num_product_conditionServiceImpl num_product_conditionServiceImpl;

    public GiftServiceImpl(GiftRepo giftRepo, ImagesServiceImpl imagesServiceImpl, Product_itemServiceImpl product_itemServiceImpl, num_product_conditionServiceImpl num_product_conditionServiceImpl) {
        this.giftRepo = giftRepo;
        this.imagesServiceImpl = imagesServiceImpl;
        this.product_itemServiceImpl = product_itemServiceImpl;
        this.num_product_conditionServiceImpl = num_product_conditionServiceImpl;
    }

    @Override
    public GiftDto save(GiftDto dto) {
        List<String> errors = GiftValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Promotion not Valid {}",Errorcode.PROMOTION_NOT_VALID,errors);
        }
        Product_itemDto productDto;
        List<num_product_conditionDto> list=new ArrayList<>();
        for (num_product_conditionDto p : dto.getProducts_condition()) {
            productDto = product_itemServiceImpl.findById(p.getProductid());
            if (p.getQte() > 0 && productDto.getQte().compareTo(BigDecimal.valueOf(p.getQte()))>=0) {
                num_product_conditionServiceImpl.save(p);
                list.add(p);
            }
        }
        dto.setProducts_condition(list);
        List<ImagesDto> list2=new ArrayList<>();
        if (dto.getGiftimages()!=null){
            dto.getGiftimages().forEach(i->{
                if (i.getId()!=null){
                    list2.add(imagesServiceImpl.findById(i.getId()));
                }else {
                    list2.add(imagesServiceImpl.save(i));
                }
            });
            dto.setGiftimages(list2);
        }
        try {
            return GiftDto.fromEntity(giftRepo.save(GiftDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Long Id) {
        try {
            giftRepo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
    @Override
    public GiftDto findById(Long id) {
        return giftRepo.findById(id)
                .map(GiftDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("gift not found "));
    }

    @Override
    public List<GiftDto> findAll() {
        return giftRepo.findAll().stream().map(GiftDto::fromEntity).collect(Collectors.toList());
    }
}
