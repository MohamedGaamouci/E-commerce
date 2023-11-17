//package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
//
//import com.gmc_team.e_commerse_platform.Dto.Order_reviewDto;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static com.gmc_team.e_commerse_platform.Dto.Order_reviewDto.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class Order_reviewServiceImplTest {
//
//    @Autowired
//    private Order_reviewServiceImpl order_reviewServiceImpl;
//    @Autowired
//    private OrderServiceImpl customer_orderServiceImpl;
//
//    @Test
//    void save() {
//        Order_reviewDto dto = builder()
//                .online_shop(2222L)
//                .comment("bla bla bla bla review")
//                .rating(5)
//                .customer_orderDto(1L)
//                .customer_id(1L)
//                .build();
//        Order_reviewDto saved =order_reviewServiceImpl.save(dto);
//
//        assertEquals(dto.getRating() ,saved.getRating());
//        assertNotNull(saved ,"saved is null");
//        assertNotNull(saved.getId() ,"saved id is null");
//        assertNotNull(saved.getCustomer_orderDto() ,"saved id is null");
//    }
//}