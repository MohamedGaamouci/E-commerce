package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.SellersDto;
import com.gmc_team.e_commerse_platform.Repository.SellerRepo;
import com.gmc_team.e_commerse_platform.Services.SellerService;
import com.gmc_team.e_commerse_platform.Validator.SellersValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Roles;
import com.gmc_team.e_commerse_platform.models.SellerStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.*;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {
    private final SellerRepo sellerRepo;
    private final AddressServiceImpl addressServiceImpl;

    public SellerServiceImpl(SellerRepo sellerRepo, AddressServiceImpl addressServiceImpl) {
        this.sellerRepo = sellerRepo;
        this.addressServiceImpl = addressServiceImpl;
        }

    @Override
    public SellersDto findById(Long Id) {
        return sellerRepo.findById(Id).map(SellersDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Seller found with ID:"
                        +Id ,SELLER_NOT_FOUND));
    }

    @Override
    public SellersDto save(SellersDto dto) {
        List<String> errors = SellersValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("the Seller Entity not Valid {}"
                    , SELLER_NOT_VALID,errors);
        }


        if(sellerRepo.findByUsername(dto.getUser_Name())!=null&&dto.getId()==null){
            throw new InvalidOperationException("the Seller Username is Already Exist {"+dto.getUser_Name()+"}"
                    ,SELLER_ALREADY_IN_USE);
        }
        if(sellerRepo.findByEmail(dto.getEmail())!=null&&dto.getId()==null){
            throw new InvalidOperationException("the Seller Email is Already Exist {"+dto.getEmail()+"}"
                    ,SELLER_ALREADY_IN_USE);
        }
            if(dto.getAddress().getId() != null){
                dto.setAddress(addressServiceImpl.findById(dto.getAddress().getId()));
            }else {
                dto.setAddress(addressServiceImpl.save(dto.getAddress()));
            }
        try {
            return SellersDto.fromEntity(sellerRepo.save(SellersDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public List<SellersDto> findAll() {
        return sellerRepo.findAll()
                .stream()
                .map(SellersDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SellersDto> findByfirstNameAndSecondName(String firstName, String SecondName) {
        return sellerRepo.findAllByFirstnameAndSecondname(firstName ,SecondName)
                .stream()
                .map(SellersDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SellersDto findByUserName(String username) {
        return SellersDto.fromEntity(sellerRepo.findByUsername(username));
    }

    @Override
    public SellersDto findByEmail(String Email) {
        return SellersDto.fromEntity(sellerRepo.findByEmail(Email));
    }

    @Override
    public List<SellersDto> findByGender(String gender) {
        return sellerRepo.findAllByGender(gender)
                .stream()
                .map(SellersDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SellersDto> findByRole(List<Roles> rolesName) {
        return sellerRepo.findAllByRolesIn(rolesName)
                .stream().filter(customers -> new HashSet<>(customers.getRoles()).containsAll(rolesName))
                .map(SellersDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void disactivate(Long id) {
        SellersDto dto =findById(id);
        dto.setStatus(SellerStatus.disactivate);
        save(dto);
    }

    @Override
    public void delete(Long id) {
        try {
            SellersDto dto = findById(id);
            if(dto.getRoles().contains(Roles.store_owner)){
                throw new InvalidOperationException("can delete a User with store owner Role");
            }
            sellerRepo.deleteById(id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage(),SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void activate(Long id) {
        SellersDto dto =findById(id);
        dto.setStatus(SellerStatus.activate);
        save(dto);
    }
}
