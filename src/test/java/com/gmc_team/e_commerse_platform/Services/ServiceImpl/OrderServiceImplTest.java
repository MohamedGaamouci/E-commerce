//package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
//
//import com.gmc_team.e_commerse_platform.Dto.*;
//import com.gmc_team.e_commerse_platform.models.Order_status;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class OrderServiceImplTest {
//
//    private final Order_lineServiceImpl order_lineServiceImpl;
//    private OrderServiceImpl service;
//    private Shipping_methodServiceImpl serviceMethod;
//    private Customer_payment_mehtodServiceImpl customer_payment_mehtodServiceImpl;
//    private AddressServiceImpl addressServiceImpl;
//
//    @Autowired
//    public OrderServiceImplTest(
//            OrderServiceImpl service
//            , Shipping_methodServiceImpl serviceMethod
//            , Customer_payment_mehtodServiceImpl customer_payment_mehtodServiceImpl
//            , AddressServiceImpl addressServiceImpl, Order_lineServiceImpl order_lineServiceImpl) {
//        this.service = service;
//        this.serviceMethod = serviceMethod;
//        this.customer_payment_mehtodServiceImpl = customer_payment_mehtodServiceImpl;
//        this.addressServiceImpl = addressServiceImpl;
//        this.order_lineServiceImpl = order_lineServiceImpl;
//    }
//
//
//
//    @Test
//    void findByOrder_status() {
//        System.out.println(service.findByOrder_status(Order_status.canceled));
//    }
//
//    @Test
//    void findByShippingMethodDto() {
//        Shipping_methodDto dto =Shipping_methodDto.builder()
//                .name("see")
//                .price(BigDecimal.valueOf(222.00))
//                .customer_order(1222L)
//                .online_shop(222L)
//                .build();
//        dto = serviceMethod.save(dto);
//
//        service.findByShippingMethodDto(dto.getId());
//
//    }
//
//    @Test
//    void save() {
//        Shipping_methodDto ship = serviceMethod.findById(1L);
//        Customer_payment_mehtodDto paymentMehtodDto = customer_payment_mehtodServiceImpl.findById(1L);
//        AddressDto Adddto = addressServiceImpl.findById(1L);
////        List<Order_lineDto> orderlines = Arrays.asList(
//////                new Order_lineDto()
////        );
//        OrderDto dto = OrderDto.builder()
//                .customer_id(2111L)
//                .order_status(Order_status.delivered)
//                .shippingMethodDto(ship)
//                .paymentMethodDto(paymentMehtodDto)
//                .full_price(BigDecimal.valueOf(122.00))
//                .shipping_addressDto(Adddto)
//                .build();
//
//        service.save(dto);
//    }
//
//
//}