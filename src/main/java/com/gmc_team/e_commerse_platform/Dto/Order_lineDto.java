package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Order_line;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Order_lineDto {
    private Long Id;
    private BigDecimal qte;
    private BigDecimal price;
    private Long online_shop;
    private Product_itemDto product_itemDto;
    private Long orderDto;

    private Long onlineshop;
    public static Order_line toEntity(Order_lineDto dto){
        if(dto == null)return null;
        else {
            Order_line orderLine = new Order_line();
            orderLine.setId(dto.getId());
            orderLine.setQte(dto.getQte());
            orderLine.setPrice(dto.getPrice());
            orderLine.setOnlineshop(dto.getOnline_shop());
            orderLine.setProductitem(Product_itemDto.toEntity(dto.getProduct_itemDto()));
            orderLine.setOrderid(dto.getOrderDto());
            orderLine.setOnlineshop(dto.getOnlineshop());
            return orderLine;
        }
    }
    public static Order_lineDto fromEntity(Order_line orderLine){
        if(orderLine == null)return null;
        else return Order_lineDto.builder()
                .Id(orderLine.getId())
                .qte(orderLine.getQte())
                .price(orderLine.getPrice())
                .online_shop(orderLine.getOnlineshop())
                .product_itemDto(Product_itemDto.fromEntity(orderLine.getProductitem()))
                .orderDto(orderLine.getOrderid())
                .onlineshop(orderLine.getOnlineshop())
                .build();
    }
}
