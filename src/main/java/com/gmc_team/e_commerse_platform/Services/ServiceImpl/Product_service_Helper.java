package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.CategoryDto;
import com.gmc_team.e_commerse_platform.Dto.ProductDto;
import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;
import com.gmc_team.e_commerse_platform.Repository.ProductRepo;
import com.gmc_team.e_commerse_platform.Repository.Product_itemRepo;
import com.gmc_team.e_commerse_platform.exceptions.EntityNotFoundException;
import com.gmc_team.e_commerse_platform.exceptions.Errorcode;
import com.gmc_team.e_commerse_platform.exceptions.InvalidDataBaseOperationException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.PRODCUT_NOT_FOUND_EXCEPTION;

@Service
@Transactional
public class Product_service_Helper {
    private final ProductRepo productRepo;
    private final Product_itemRepo product_itemRepo;

    public Product_service_Helper(ProductRepo productRepo, Product_itemRepo product_itemRepo) {
        this.productRepo = productRepo;
        this.product_itemRepo = product_itemRepo;
    }

    public void deleteProduct(Long Id) {
        ProductDto product = findById(Id);

        try {
            product.setCategoryDto(null);
            product.getProductitems().forEach(p->{
                p.setVariation_optionDtos(null);
                p.setVariation_optionDtos(null);
                product_itemRepo.delete(Product_itemDto.toEntity(p));
            });
            product.setProductitems(null);
            productRepo.delete(ProductDto.toEntity(product));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }
    }
    public List<ProductDto> findProductByCategory(CategoryDto Category) {
        return productRepo.findAllByCategory(CategoryDto.toEntity(Category)).stream()
                .map(val->ProductDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }
    public ProductDto findById(Long Id) {
        return productRepo.findById(Id).map(val->ProductDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No Product found with ID:"
                        +Id ,PRODCUT_NOT_FOUND_EXCEPTION));
    }
}
