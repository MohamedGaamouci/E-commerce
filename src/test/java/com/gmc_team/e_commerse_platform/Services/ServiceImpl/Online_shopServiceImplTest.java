//package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
//
//import com.gmc_team.e_commerse_platform.Dto.AddressDto;
//import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;
//import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
//import com.gmc_team.e_commerse_platform.Dto.SellersDto;
//import com.gmc_team.e_commerse_platform.models.Gender;
//import com.gmc_team.e_commerse_platform.models.Roles;
//import com.gmc_team.e_commerse_platform.models.Specialities;
//import com.gmc_team.e_commerse_platform.models.Store_status;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Instant;
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class Online_shopServiceImplTest {
//
//    @Autowired
//    private SellerServiceImpl sellerServiceImpl;
//    @Autowired
//    private Online_shopServiceImpl online_shopServiceImpl;
//    @Autowired
//    private AddressServiceImpl addressServiceImpl;
//    @Autowired
//    private DescriptionServiceImpl descriptionServiceImpl;
//
//    @Test
//    @Transactional
//    void save() {
//        AddressDto addressDto = AddressDto.builder()
//                .online_shop(2222L)
//                .phone(72333333L)
//                .add1("add1")
//                .country("Algeria")
//                .state("Tiaret")
//                .postal_code(14003)
//                .city("Sougueur")
//                .build();
//        addressDto =addressServiceImpl.save(addressDto);
//
//        SellersDto sellersDto = SellersDto.builder()
//                .User_Name("Mohamed")
//                .gender(Gender.Male)
//                .Email("gaamoucimohamed@gmail.com")
//                .roles(Arrays.asList(Roles.store_owner , Roles.Seller_Employee))
//                .birth_day(Instant.now())
//                .address(addressDto)
//                .first_Name("gaamouci")
//                .second_Name("mounsif")
//                .build();
//        sellersDto = sellerServiceImpl.save(sellersDto);
//
//        DescriptionsDto descriptionsDto = DescriptionsDto.builder()
//                .description("bla bla bla bla store desctription")
//                .title("store Description")
//                .online_shop(2222L)
//                .build();
//        descriptionsDto =descriptionServiceImpl.save(descriptionsDto);
//
//
//        Online_shopDto dto = Online_shopDto.builder()
//                .store_Name("Mohamed Shop")
//                .store_owner(sellersDto)
//                .speciality(Specialities.clothing)
//                .store_status(Store_status.active)
//                .store_descriptionsDtos(Arrays.asList(descriptionsDto))
//
//                .build();
//        Online_shopDto saved;
//        saved = online_shopServiceImpl.save(dto);
//
//        assertEquals(dto.getStore_owner() ,saved.getStore_owner());
//        assertNotNull(saved ,"saved is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//        assertNotNull(saved.getStore_owner() ,"saved id is null");
//
//    }
//}