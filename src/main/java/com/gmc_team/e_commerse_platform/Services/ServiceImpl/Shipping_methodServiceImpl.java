package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.Delevery_time_detailDto;
import com.gmc_team.e_commerse_platform.Dto.Shipping_methodDto;
import com.gmc_team.e_commerse_platform.Repository.Shipping_methodRepo;
import com.gmc_team.e_commerse_platform.Services.Shipping_methodService;
import com.gmc_team.e_commerse_platform.Validator.Shipping_methodValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Shipping_method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.*;


@Service
@Transactional
public class Shipping_methodServiceImpl implements Shipping_methodService {
    private final Shipping_methodRepo shippingMethodRepo;
    private final Delevery_time_detailServiceImpl delevery_time_detailServiceImpl;

    @Autowired
    public Shipping_methodServiceImpl(Shipping_methodRepo shippingMethodRepo, Delevery_time_detailServiceImpl delevery_time_detailServiceImpl) {
        this.shippingMethodRepo = shippingMethodRepo;
        this.delevery_time_detailServiceImpl = delevery_time_detailServiceImpl;
    }

    @Override
    public Shipping_methodDto findById(Long Id) {
        if(Id == null||Id <=0){
            throw new InvalidOperationException("the Id Can not be null or negative ", ID_CAN_NOT_BE_NULL_OR_NEGATIVE);
        }
        return shippingMethodRepo.findById(Id)
                .map(Shipping_methodDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Shipping Method with the following Id :"+Id, METHOD_NOT_FOUND));
    }

    @Override
    public Shipping_methodDto save(Shipping_methodDto dto) {
        List<String> errors = Shipping_methodValidator.Validate(dto);

        if(!errors.isEmpty()){
            throw new InvalidEntityException("Shipping Method Entity Not valide {}",Errorcode.SHIPPING_METHOD_NOT_VALID,errors);
        }
        Shipping_method method= shippingMethodRepo.findByName(dto.getName());
        if(method != null){
            throw new InvalidOperationException("the Method Name is already in Use ",SHIPPING_METHOD_NOT_VALID);
        }
        List<Delevery_time_detailDto> details=new ArrayList<>();
        if(dto.getTimeDetail()!=null){
            dto.getTimeDetail().forEach(t->details.add(delevery_time_detailServiceImpl.save(t)));
        }
        dto.setTimeDetail(details);
        method = shippingMethodRepo.save(Shipping_methodDto.toEntity(dto));

        try {
            return Shipping_methodDto.fromEntity(method);

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public List<Shipping_methodDto> findAll() {
        return shippingMethodRepo.findAll().stream()
                .map(Shipping_methodDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Shipping_methodDto findByName(String shipping_Name) {
        return Shipping_methodDto.fromEntity(shippingMethodRepo.findAllByName(shipping_Name));
    }

    @Override
    public Shipping_methodDto findBycustomer_order(Long customer_order_ID) {
        return Shipping_methodDto.fromEntity(shippingMethodRepo.findAllByCustomerorder(customer_order_ID));
    }
    @Override
    public void delete(Long shippingMethodId) {
        try {
            shippingMethodRepo.deleteById(shippingMethodId);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }

    }
}
