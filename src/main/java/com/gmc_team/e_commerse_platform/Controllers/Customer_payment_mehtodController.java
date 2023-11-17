package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Customer_payment_mehtodApi;
import com.gmc_team.e_commerse_platform.Dto.Customer_payment_mehtodDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Customer_payment_mehtodServiceImpl;
import com.gmc_team.e_commerse_platform.models.Payment_type;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Customer_payment_mehtodController implements Customer_payment_mehtodApi {


    private final Customer_payment_mehtodServiceImpl service;

    public Customer_payment_mehtodController(Customer_payment_mehtodServiceImpl service) {
        this.service = service;
    }

    @Override
    public Customer_payment_mehtodDto save(Customer_payment_mehtodDto dto) {
        return service.save(dto);
    }

    @Override
    public Customer_payment_mehtodDto findById(Long Id) {
        return service.findById(Id);

    }

    @Override
    public List<Customer_payment_mehtodDto> findAll() {
        return service.findAll();
    }

    @Override
    public List<Customer_payment_mehtodDto> findByPayment_type(Payment_type payment_type) {
        return service.findByPayment_type(payment_type);
    }

    @Override
    public List<Customer_payment_mehtodDto> findByProvider(String Provider) {
        return service.findByProvider(Provider);
    }

//    @Override
//    public List<Customer_payment_mehtodDto> findByIs_default(Boolean Is_default) {
//        return service.findByIs_default(Is_default);
//    }
}
