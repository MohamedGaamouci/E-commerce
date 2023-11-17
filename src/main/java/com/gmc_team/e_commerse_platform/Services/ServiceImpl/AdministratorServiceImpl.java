package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.AddressDto;
import com.gmc_team.e_commerse_platform.Dto.AdministratorsDto;
import com.gmc_team.e_commerse_platform.Repository.AdministratorRepo;
import com.gmc_team.e_commerse_platform.Services.AdministratorService;
import com.gmc_team.e_commerse_platform.Validator.AdministratorsValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Administrators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.*;
@Service
@Transactional
public class
AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepo repo;
    private final AddressServiceImpl AddService;
    @Autowired
    public AdministratorServiceImpl(AdministratorRepo repo, AddressServiceImpl AddService) {
        this.repo = repo;
        this.AddService = AddService;
    }




    @Override
    public AdministratorsDto save(AdministratorsDto dto) {
        List<String> errors = AdministratorsValidator.Validate(dto);

        boolean exist;
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Adminstrator is not Valid {}" , ADMINISTRATOR_NOT_VALID ,errors);
        }else if (dto.getId() == null){
            exist = UserNameExist(dto.getUsername());
            exist = exist || EmailExist(dto.getEmail());
            if(exist) {throw new InvalidEntityException("Adminstrator UserName or Email is Already Used {}"
                , ADMINISTRATOR_USERNAME_ALREAY_EXIST );}
        }
        AddressDto add;

        if(dto.getAddress().getId() != null){
        add = AddService.findById(dto.getAddress().getId());
        dto.setAddress(add);
        }else {
            add = AddService.save(dto.getAddress());
            dto.setAddress(add);
        }

        try {
            return AdministratorsDto.fromEntity(repo.save(AdministratorsDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public AdministratorsDto findById(Long Id) {
        if(Id ==null||Id <=0){
            throw new InvalidEntityException("The ID cannot be null or negative", ID_CAN_NOT_BE_NULL_OR_NEGATIVE );
        }
        return repo.findById(Id).map(AdministratorsDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Administrator found with ID:"
                        +Id ,ADMINISTRATOR_NOT_FOUND));
    }

    @Override
    public AdministratorsDto findByUserName(String username) {
        AdministratorsDto dto= AdministratorsDto.fromEntity(repo.findByUsername(username));
        if(dto == null){
            throw new EntityNotFoundException("No Administrator found with the following UserName :: "
                    +username ,ADMINISTRATOR_NOT_FOUND);
        }
        return dto;
    }

    @Override
    public List<AdministratorsDto> findAll() {
        return repo.findAll().stream()
                .map(AdministratorsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdministratorsDto> findByfirstNameAndSecondName(String firstName, String SecondName) {
        return repo.findAllByFirstNameAndSecondName(firstName ,SecondName).stream()
                .map(AdministratorsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdministratorsDto findByEmail(String Email) {
        AdministratorsDto dto= AdministratorsDto.fromEntity(repo.findByEmail(Email));
        if(dto == null){
            throw new EntityNotFoundException("No Administrator found with the following Email :: "
                    +Email ,ADMINISTRATOR_NOT_FOUND);
        }
        return dto;
    }

    public Boolean UserNameExist(String username){
        Administrators admin = repo.findByUsername(username);
        return admin != null;

    }

    @Override
    public void delete(Long Id) {

        try {
            repo.deleteById(Id);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    public Boolean EmailExist(String Email){
        Administrators admin = repo.findByEmail(Email);
        return admin != null;

    }
}
