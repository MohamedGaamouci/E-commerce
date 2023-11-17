//package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
//
//import com.gmc_team.e_commerse_platform.Dto.CustomersDto;
//import com.gmc_team.e_commerse_platform.models.Gender;
//import com.gmc_team.e_commerse_platform.models.Roles;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.Instant;
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//
//class CustomerServiceImplTest {
//
//
//    @Autowired
//    private CustomerServiceImpl customerServiceImpl;
//    @Autowired
//    private AddressServiceImpl addressServiceImpl;
//
//    @Test
//    void save() {
//        CustomersDto dto = CustomersDto.builder()
//                .Name("gaamouci")
//                .Second_Name("mohamed")
//                .birth_day(Instant.now())
//                .User_Name("gaamouci")
//                .Email("gaamoucimohamed@gmail.com")
//                .gender(Gender.Male)
//                .roles(Arrays.asList(Roles.customer))
//                .address(Arrays.asList(addressServiceImpl.findById(1L)))
//                .build();
//        CustomersDto saved =customerServiceImpl.save(dto);
//
//        assertEquals(dto.getUser_Name() ,saved.getUser_Name());
//        assertNotNull(saved ,"saved is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//    }
//}