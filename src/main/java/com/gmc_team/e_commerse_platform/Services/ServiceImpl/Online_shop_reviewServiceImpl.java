package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.CustomersDto;
import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Dto.Online_shop_reviewDto;
import com.gmc_team.e_commerse_platform.Repository.Online_shop_reviewRepo;
import com.gmc_team.e_commerse_platform.Services.Online_shop_reviewService;
import com.gmc_team.e_commerse_platform.Validator.Online_shop_reviewValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Online_shop_review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Online_shop_reviewServiceImpl implements Online_shop_reviewService {
    private final Online_shop_reviewRepo online_shop_reviewRepo;
    private final CustomerServiceImpl customerServiceImpl;
    private final Online_shopServiceImpl online_shopServiceImpl;

    @Autowired
    public Online_shop_reviewServiceImpl(Online_shop_reviewRepo online_shop_reviewRepo, CustomerServiceImpl customerServiceImpl, Online_shopServiceImpl online_shopServiceImpl) {
        this.online_shop_reviewRepo = online_shop_reviewRepo;
        this.customerServiceImpl = customerServiceImpl;
        this.online_shopServiceImpl = online_shopServiceImpl;
    }

    @Override
    public Online_shop_reviewDto findById(Long Id) {
        return online_shop_reviewRepo.findById(Id)
                .map(Online_shop_reviewDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No shop review with the following Id :"+Id
                , Errorcode.SHOP_REVIEW_NOT_FOUND_EXCEPTION));
    }

    @Override
    public Online_shop_reviewDto save(Online_shop_reviewDto Id) {
        List<String> errors = Online_shop_reviewValidator.Validate(Id);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("The shop review is not valid {}"
            ,Errorcode.SHOP_REVIEW_NOT_VALID_EXCEPTION ,errors);
        }
        Online_shopDto onlineShopDto =online_shopServiceImpl.findById(Id.getOnline_shop_idDto());

        Id.setOnline_shop_idDto(onlineShopDto.getId());
        CustomersDto dto =customerServiceImpl.findById(Id.getCustomers_idDto());


        Online_shop_review review =online_shop_reviewRepo.findByCustomersidAndOnlineshop(
                CustomersDto.toEntity(dto) ,onlineShopDto.getId()
        );
        if(review != null&& Id.getId() == null){
            throw new InvalidOperationException("You already submited a review with the id:"+Id.getCustomers_idDto() ,
                    Errorcode.CUSTOMER_ALREADY_IN_USE);
        }
        Id.setCustomers_idDto(dto.getId());
        try {
            return Online_shop_reviewDto.fromEntity(
                online_shop_reviewRepo.save(
                        Online_shop_reviewDto.toEntity(Id)
                )
        );

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public Online_shop_reviewDto findByCustomerId(Long Id) {
        CustomersDto customers = customerServiceImpl.findById(Id);

        return Online_shop_reviewDto.fromEntity(online_shop_reviewRepo.findByCustomersid(CustomersDto.toEntity(customers)));
    }

    @Override
    public Online_shop_reviewDto findByCustomerIdAndOnline_shopId(Long customer, Long online) {
        CustomersDto customers = customerServiceImpl.findById(customer);
        online_shopServiceImpl.findById(online);
        return Online_shop_reviewDto.fromEntity(
                online_shop_reviewRepo.findByCustomersidAndOnlineshop(
                        CustomersDto.toEntity(customers ),online
                )
        );
    }

    @Override
    public List<Online_shop_reviewDto> findByOnline_shopId(Long Id) {
        online_shopServiceImpl.findById(Id);

        return online_shop_reviewRepo.findAllByOnlineshop(Id)
                .stream().map(Online_shop_reviewDto::fromEntity)
                .collect(Collectors.toList());
    }

}
