package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.*;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private Long Id;
    private Order_status order_status;
    private Shipping_methodDto shippingMethodDto;
    private Long customer_id ;
    private Customer_payment_mehtodDto paymentMethodDto;
    private BigDecimal full_price;
    private AddressDto shipping_addressDto;
    private List<Order_lineDto> orderLines;
    private Order_reviewDto reviewDto;
    private Long onlineshop;


    public static Order toEntity(OrderDto dto){
        if(dto == null)return null;
        else{
            Order order = new Order();

            order.setId(dto.getId());
            order.setOrderstatus(dto.getOrder_status());
            order.setShippingMethod(Shipping_methodDto.toEntity(dto.getShippingMethodDto()));
            order.setCustomerid(dto.getCustomer_id());
            order.setPaymentmethod(Customer_payment_mehtodDto.toEntity(dto.getPaymentMethodDto()));
            order.setFullprice(dto.getFull_price());
            order.setShippingaddress(AddressDto.toEntity(dto.getShipping_addressDto()));
            order.setReview(Order_reviewDto.toEntity(dto.getReviewDto()));
                if (dto.getOrderLines() !=null){
                List<Order_line> list = new ArrayList<>();
                dto.getOrderLines().forEach(line->list.add(Order_lineDto.toEntity(line)));
                order.setOrderlines(list);
                }
            order.setOnlineshop(dto.getOnlineshop());
            return order;

        }
    }
    public static OrderDto fromEntity(Order customerOrder){
        if(customerOrder == null ) return null;
        else{
            List<Order_lineDto> list = new ArrayList<>();
            if(customerOrder.getOrderlines() !=null){
            customerOrder.getOrderlines().forEach(line->list.add(Order_lineDto.fromEntity(line)));
            }
            return OrderDto.builder()
                    .Id(customerOrder.getId())
                    .order_status(customerOrder.getOrderstatus())
                    .shippingMethodDto(Shipping_methodDto.fromEntity(customerOrder.getShippingMethod()))
                    .customer_id(customerOrder.getCustomerid())
                    .paymentMethodDto(Customer_payment_mehtodDto.fromEntity(customerOrder.getPaymentmethod()))
                    .full_price(customerOrder.getFullprice())
                    .shipping_addressDto(AddressDto.fromEntity(customerOrder.getShippingaddress()))
                    .reviewDto(Order_reviewDto.fromEntity(customerOrder.getReview()))
                    .orderLines(list)
                    .onlineshop(customerOrder.getOnlineshop())
                    .build();
        }
    }
}
