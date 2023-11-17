package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Delevery_time_detail;
import com.gmc_team.e_commerse_platform.models.Shipping_method;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Shipping_methodDto {
    private Long Id;
    private String name;
    private BigDecimal price;
    private Long online_shop;
    private Long customer_order;
    private List<Delevery_time_detailDto> timeDetail;

    public static Shipping_method toEntity(Shipping_methodDto dto){
        if(dto == null)return null;
        else{
            Shipping_method method = new Shipping_method();

            method.setId(dto.getId());
            method.setName(dto.getName().trim());
            method.setPrice(dto.getPrice());
            method.setOnline_shop(dto.getOnline_shop());
            method.setCustomerorder(dto.getCustomer_order());
            if(dto.getTimeDetail() != null){
            List<Delevery_time_detail> list = new ArrayList<>();
            dto.getTimeDetail().forEach(time->list.add(Delevery_time_detailDto.toEntity(time)));
            method.setTimeDetail(list);
            }
            return method;
        }
    }
    public static Shipping_methodDto fromEntity(Shipping_method method){
        if(method == null)return null;
        else{
            List<Delevery_time_detailDto> list = new ArrayList<>();
            if(method.getTimeDetail()!=null) {
                method.getTimeDetail().forEach(time -> list.add(Delevery_time_detailDto.fromEntity(time)));
            }

            return Shipping_methodDto.builder()
                .Id(method.getId())
                .name(method.getName())
                .price(method.getPrice())
                .online_shop(method.getOnline_shop())
                .customer_order(method.getCustomerorder())
                    .timeDetail(list)
                .build();}
    }
}
