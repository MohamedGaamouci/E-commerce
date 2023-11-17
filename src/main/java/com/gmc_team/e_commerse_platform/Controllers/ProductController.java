package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.ProductApi;
import com.gmc_team.e_commerse_platform.Dto.*;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.ProductServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi {
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @Override
    public ProductDto findById(Long Id) {
        return productServiceImpl.findById(Id);
    }


    @Override
    public ProductDto save(ProductDto dto) {
        return productServiceImpl.save(dto);
    }

    @Override
    public List<ProductDto> findAll() {
        return productServiceImpl.findAll();
    }

    @Override
    public List<ProductDto> findByName(String Name) {
        return productServiceImpl.findByName(Name);
    }

    @Override
    public List<ProductDto> findAllProductBySKUId(Long Id) {
        return productServiceImpl.findAllProductBySKUId(Id);
    }

    @Override
    public List<ProductDto> findAllProductBySKUId(String Name) {
        return productServiceImpl.findAllProductBySKUName(Name);
    }

    @Override
    public void deleteProduct(Long Id) {
        productServiceImpl.deleteProduct(Id);
    }

    @Override
    public List<DescriptionsDto> findAllDescriptionByProductId(Long Id) {
        return productServiceImpl.findAllDescriptionByProductId(Id);
    }

    @Override
    public List<ProductDto> findProductByCategory(Long CategoryId) {
        return productServiceImpl.findProductByCategory(CategoryId);
    }

    @Override
    public List<ImagesDto> findAllImagesByProductId(Long Id) {
        return productServiceImpl.findAllImagesByProductId(Id);
    }

    @Override
    public List<Product_reviewDto> findAllProduct_reviewByProductId(Long Id) {
        return productServiceImpl.findAllProduct_reviewByProductId(Id);
    }

    @Override
    public List<Product_itemDto> findAllVariationProductByProductId(Long Id) {
        return productServiceImpl.findAllVariationProductByProductId(Id);
    }

    @Override
    public ProductDto update_promotion_on_product(Promotion_detailDto dto, Long product_id) {
        return productServiceImpl.update_promotion_on_product(dto ,product_id);
    }
}
