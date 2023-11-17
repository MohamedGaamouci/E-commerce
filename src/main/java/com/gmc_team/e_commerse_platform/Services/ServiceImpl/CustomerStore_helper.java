package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.AddressDto;
import com.gmc_team.e_commerse_platform.Dto.CustomersDto;
import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Repository.CustomerRepo;
import com.gmc_team.e_commerse_platform.Validator.CustomerValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.*;

@Service
@Transactional
public class CustomerStore_helper {


    private final CustomerRepo customerRepo;
    private final AddressServiceImpl addressServiceImpl;
    private final Online_shopHelper online_shopHelper;


    @Autowired
    public CustomerStore_helper(CustomerRepo customerRepo, AddressServiceImpl addressServiceImpl, Online_shopHelper online_shopHelper) {
        this.customerRepo = customerRepo;
        this.addressServiceImpl = addressServiceImpl;
        this.online_shopHelper = online_shopHelper;
    }

    public CustomersDto findById(Long Id) {
         return customerRepo.findById(Id).map(val->CustomersDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No Customer found with ID:"
                        +Id ,CUSTOMER_NOT_FOUND));
    }

    public CustomersDto save(CustomersDto dto) {
        List<String> errors = CustomerValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("the Customer Entity not Valid {}"
                    , CUSTOMER_NOT_VALID,errors);
        }
        if(customerRepo.findByUsername(dto.getUser_Name())!=null&&dto.getId()==null){
            throw new InvalidOperationException("the Customer Username is Already Exist {"+dto.getUser_Name()+"}"
                    ,CUSTOMER_ALREADY_IN_USE);
        }
        if(customerRepo.findByEmail(dto.getEmail())!=null&&dto.getId()==null){
            throw new InvalidOperationException("the Customer Email is Already Exist {"+dto.getEmail()+"}"
                    ,CUSTOMER_ALREADY_IN_USE);
        }
        List<AddressDto> add = new ArrayList<>();
        dto.getAddress().forEach(address->{
            if(address.getId() != null){
                add.add(addressServiceImpl.findById(address.getId()));
            }else {
                add.add(addressServiceImpl.save(address));
            }
        });
        dto.setAddress(add);

        List<Online_shopDto> register_Stores= new ArrayList<>();
        if(dto.getRegisterstores() !=null){
            dto.getRegisterstores().forEach(reg->{
                if(reg.getId() !=null){
                    register_Stores.add(online_shopHelper.findById(reg.getId()));
                }else{
                    throw new InvalidOperationException("the Store Id Can not Be Null "
                            , ONLINE_SHOP_NOT_VALID_EXCEPTION);
                }
            });
        }
        dto.setRegisterstores(register_Stores);

        try {
            return CustomersDto.fromEntity(customerRepo.save(CustomersDto.toEntity(dto)),true);

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }



}
