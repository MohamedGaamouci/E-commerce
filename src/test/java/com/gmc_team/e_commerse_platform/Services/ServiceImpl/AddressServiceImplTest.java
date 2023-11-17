//package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
//
//import com.gmc_team.e_commerse_platform.Dto.AddressDto;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//class AddressServiceImplTest {
//
//    @Autowired
//    private AddressServiceImpl service;
//
//    @Test
//    void save() {
//        AddressDto addressDto = AddressDto.builder()
//                .Id(2L)
//                .country("Algeria")
//                .add1("add1")
//                .add2("add2")
//                .state("tiaret")
//                .postal_code(14003)
//                .city("sougueur")
//                .phone(779209330L)
//                .online_shop(23333L)
//                .build();
//        AddressDto saved =service.save(addressDto);
//
//        assertNotNull(saved ,"saved is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//        assertEquals(saved.getPostal_code() ,addressDto.getPostal_code());
//        assertEquals(saved.getAdd1() ,addressDto.getAdd1());
//        assertEquals(saved.getOnline_shop() ,addressDto.getOnline_shop());
//
//    }
//
//    @Test
//    void findById() {
//        AddressDto addressDto = AddressDto.builder()
//                .Id(2L)
//                .country("Algeria")
//                .add1("add1")
//                .add2("add2")
//                .state("tiaret")
//                .postal_code(14003)
//                .city("sougueur")
//                .phone(779209330L)
//                .online_shop(23333L)
//                .build();
//        AddressDto saved =service.findById(2L);
//        System.out.println(saved);
//
//        assertNotNull(saved ,"saved is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//        assertEquals(saved.getPostal_code() ,addressDto.getPostal_code());
//        assertEquals(saved.getAdd1() ,addressDto.getAdd1());
//        assertEquals(saved.getOnline_shop() ,addressDto.getOnline_shop());
//    }
//}