package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.Customer_payment_mehtodDto;
import com.gmc_team.e_commerse_platform.Repository.Customer_payment_mehtodRepo;
import com.gmc_team.e_commerse_platform.Services.Customer_payment_mehtodService;
import com.gmc_team.e_commerse_platform.Validator.Customer_payment_mehtodValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Payment_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.PAYMENT_METHOD_NOT_VALID;
import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.SQL_STATEMENT_FAILD_OPERATION;

@Service
@Transactional
public class Customer_payment_mehtodServiceImpl implements Customer_payment_mehtodService {
    private final Customer_payment_mehtodRepo repo;

    @Autowired
    public Customer_payment_mehtodServiceImpl(Customer_payment_mehtodRepo repo) {
        this.repo = repo;
    }

    @Override
    public Customer_payment_mehtodDto save(Customer_payment_mehtodDto dto) {
        List<String> errors = Customer_payment_mehtodValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Invalid Payment method {}" , PAYMENT_METHOD_NOT_VALID,errors);
        }
        try {

            return Customer_payment_mehtodDto
                .fromEntity(repo.save(Customer_payment_mehtodDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public Customer_payment_mehtodDto findById(Long Id) {
        return repo.findById(Id)
                .map(Customer_payment_mehtodDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Payment method found with the following Id ::"+Id, Errorcode.PAYMENT_METHOD_NOT_FOUND));
    }



    @Override
    public List<Customer_payment_mehtodDto> findAll() {
        return repo.findAll()
                .stream()
                .map(Customer_payment_mehtodDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer_payment_mehtodDto> findByPayment_type(Payment_type type) {
        return repo.findAllByPaymenttype(type)
                .stream()
                .map(Customer_payment_mehtodDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer_payment_mehtodDto> findByProvider(String provider) {
        return repo.findAllByProvider(provider)
                .stream()
                .map(Customer_payment_mehtodDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer_payment_mehtodDto> findByIs_default(Boolean b) {
        return repo.findAllByIsdefault(b)
                .stream()
                .map(Customer_payment_mehtodDto::fromEntity)
                .collect(Collectors.toList());
    }

    public void delete(Long paymentId) {
        try {
            repo.deleteById(paymentId);
        }catch(DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
}
