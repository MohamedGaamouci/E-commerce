//package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
//
//import com.gmc_team.e_commerse_platform.Dto.Customer_payment_mehtodDto;
//import com.gmc_team.e_commerse_platform.models.Payment_type;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class PaymentmethodServiceImplTest {
//    @Autowired
//    private Customer_payment_mehtodServiceImpl service;
//    @Test
//    void save() {
//        Customer_payment_mehtodDto paypal = Customer_payment_mehtodDto.builder()
//                .provider("Paypal")
//                .is_default(true)
//                .payment_type(Payment_type.paypal)
//                .build();
//
//        service.save(paypal);
//    }
//}