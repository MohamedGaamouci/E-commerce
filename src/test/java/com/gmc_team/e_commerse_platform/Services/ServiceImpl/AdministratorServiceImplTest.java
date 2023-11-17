//package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
//
//import com.gmc_team.e_commerse_platform.Dto.AddressDto;
//import com.gmc_team.e_commerse_platform.Dto.AdministratorsDto;
//import com.gmc_team.e_commerse_platform.models.Gender;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.Instant;
//import java.util.Arrays;
//
//import static com.gmc_team.e_commerse_platform.models.Roles.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class AdministratorServiceImplTest {
//
//    @Autowired
//    AddressServiceImpl addressService;
//    @Autowired
//    AdministratorServiceImpl service;
//
//
//    @Test
//    void save() {
////        AddressDto dto = addressService.findById(2L);
////        AddressDto addressDto = AddressDto.builder()
////                .country("Algeria")
////                .add1("add1")
////                .add2("add2")
////                .state("tiaret")
////                .postal_code(14003)
////                .city("sougueur")
////                .phone(7792093300L)
////                .online_shop(23333L)
////                .build();
//
//        AdministratorsDto dto =AdministratorsDto.builder()
//                .Email("gaamocuimohame@gmail.com")
//                .first_Name("gaamouci")
//                .second_Name("mohamed mounsif")
//                .username("Mounsif_Med")
//                .birth_day(Instant.now())
//                .gender(Gender.Male)
//                .address(AddressDto.builder()
//                        .country("Algeria")
//                        .add1("add1")
//                        .add2("add2")
//                        .state("tiaret")
//                        .postal_code(14003)
//                        .city("sougueur")
//                        .phone(7792093300L)
//                        .online_shop(23333L)
//                        .build())
//                .roles(Arrays.asList(Admin))
//                .build();
//
//
//        AdministratorsDto saved= service.save(dto);
//        assertNotNull(saved ,"saved is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//        assertNotNull(saved.getUsername() ,"saved id is null");
//        assertEquals(saved.getEmail() ,dto.getEmail());
//        assertEquals(saved.getRoles() ,dto.getRoles());
//        assertEquals(saved.getAddress() ,dto.getAddress());
//    }
//}