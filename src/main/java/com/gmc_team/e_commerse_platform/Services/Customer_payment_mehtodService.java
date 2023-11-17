package com.gmc_team.e_commerse_platform.Services;


import com.gmc_team.e_commerse_platform.Dto.Customer_payment_mehtodDto;
import com.gmc_team.e_commerse_platform.models.Payment_type;

import java.util.List;

public interface Customer_payment_mehtodService {
    Customer_payment_mehtodDto save(Customer_payment_mehtodDto dto);

    Customer_payment_mehtodDto findById(Long Id);


    List<Customer_payment_mehtodDto> findAll();

    List<Customer_payment_mehtodDto> findByPayment_type(Payment_type type);

    List<Customer_payment_mehtodDto> findByProvider(String provider);

    List<Customer_payment_mehtodDto> findByIs_default(Boolean b);
    void delete(Long paymentId);


}
