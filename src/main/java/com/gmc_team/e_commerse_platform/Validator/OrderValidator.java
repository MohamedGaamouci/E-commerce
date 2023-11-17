package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderValidator {
    public static List<String> Validate(OrderDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect Shipping Mehtod");
            errors.add("Please sellect Payment Method");
            errors.add("Please sellect Shipping Address");
            errors.add("Please sellect Products");
            errors.add("Please fill the Online store Id");
            errors.add("Please fill the customer Id");
        }else {
            if (dto.getCustomer_id() == null){
                errors.add("Please fill the customer Id");
            }
            if (dto.getOnlineshop()== null){
                errors.add("Please fill the Online store Id");
            }
        if(dto.getPaymentMethodDto() != null ){
            if(dto.getPaymentMethodDto().getId() == null){
            errors.add("Please sellect Payment Method");
            }
        }else {
            errors.add("Please sellect Payment Method");
        }
        if(dto.getShippingMethodDto() != null){
            if(dto.getShippingMethodDto().getId() == null){
            errors.add("Please sellect Shipping Mehtod");}
        }else {
            errors.add("Please sellect Payment Method");
        }
        if(dto.getShipping_addressDto() != null ){
            if(dto.getShipping_addressDto().getId() != null){
                errors.addAll(AddressValidator.Validate(dto.getShipping_addressDto()));
            }
        }else{
            errors.add("Please enter Shipping Address");
        }
        if (dto.getOrderLines()==null){
            errors.add("Please sellect Products");
        } else if (!dto.getOrderLines().isEmpty()) {
            dto.getOrderLines().forEach(line->{
                if(line.getId()==null){
                    errors.addAll(Order_lineValidator.Validate(line));
                }
            });
        }else{
            errors.add("Please sellect one product at least");
        }
        }
        return errors;
    }
}
