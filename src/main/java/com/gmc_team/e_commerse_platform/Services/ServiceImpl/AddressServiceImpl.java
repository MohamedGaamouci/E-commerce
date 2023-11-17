package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.AddressDto;
import com.gmc_team.e_commerse_platform.Repository.AddressRepo;
import com.gmc_team.e_commerse_platform.Services.AddressService;
import com.gmc_team.e_commerse_platform.Validator.AddressValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    AddressRepo repo;

    @Autowired
    public AddressServiceImpl(AddressRepo repo) {
        this.repo = repo;
    }

    @Override
    public AddressDto save(AddressDto dto) {
        List<String> errors  = AddressValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Address is not valid {}" , Errorcode.ADDRESS_NOT_VALID ,errors );
        }
        if(IsPhoneNumberUsed(dto.getPhone())){
            throw new InvalidEntityException("Phone Number is Already in use ",Errorcode.ADDRESS_NUMBER_NOT_VALID );

        }

        try {
            return AddressDto.fromEntity(repo.save(AddressDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public AddressDto findById(Long Id) {
        if(Id == null || Id <= 0){
            throw new InvalidEntityException("The ID cannot be null or negative" ,Errorcode.ADDRESS_ID_NOT_VALID);
        }
        return repo.findById(Id).map(AddressDto::fromEntity).orElseThrow(()->
                new EntityNotFoundException("No Address with id = " + Id + " was found in the database",Errorcode.ADDRESS_NOT_FOUND_EXCEPTION));
    }

    public Boolean IsPhoneNumberUsed(Long num) {
        Address addressList = repo.findFirstByPhone(num);
        return addressList != null;
    }
    public void deleteAdd(Long AddressId){
        repo.deleteById(AddressId);
    }
}
