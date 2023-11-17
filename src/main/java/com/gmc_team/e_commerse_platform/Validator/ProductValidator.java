package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {
    public static List<String> Validate(ProductDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect the a category ");
            errors.add("Please fill the Product Name ");
            errors.add("Please fill the Product price ");
            errors.add("Please sellect the SKU ");
            errors.add("Please choose for the product at least one image ");
            errors.add("Please choose for the product at least one Variation ");
            errors.add("Please fill the Online store Id");
            errors.add("Please fill the minimum order qte");
        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if (dto.getPrice()== null){
                errors.add("Please fill the Product price ");
            }
            if(dto.getCategoryDto() == null||dto.getCategoryDto().getId() == null){
                errors.add("Please sellect the a category ");
            }
            if(dto.getName() == null){
                errors.add("Please fill the Product Name ");
            }
            if(dto.getSKU() == null || dto.getSKU().getId() ==null){
                errors.add("Please sellect the SKU ");
            }
            if(dto.getProductitems() == null || dto.getProductitems().isEmpty()){
                errors.add("Please choose for the product at least one Variation ");
            }else {
                dto.getProductitems().forEach(dto1 -> {
                    errors.addAll(Product_itemValidator.Validate(dto1));
                });
            }
            if(dto.getImagesDtos() == null ||dto.getImagesDtos().isEmpty()){
                errors.add("Please choose for the product at least one image ");
            }else{
                dto.getImagesDtos().forEach(img->errors.addAll(ImagesValidator.Validate(img)));
            }
            if (dto.getMinimum_order_qte()==null){
                errors.add("Please fill the minimum order qte");
            }
        }
        return errors;
    }
}
