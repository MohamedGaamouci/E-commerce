package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.*;

import java.util.List;

public interface ProductService {
    ProductDto findById(Long Id);
    ProductDto save(ProductDto dto);
    List<ProductDto> findAll();
    List<ProductDto> findByName(String Name);

    List<ProductDto> findAllProductBySKUId(Long Id);
    List<ProductDto> findAllProductBySKUName(String skuDto);
    void deleteProduct(Long Id);

    List<DescriptionsDto> findAllDescriptionByProductId(Long Id);
    List<ProductDto> findProductByCategory(Long CategoryId);

    List<ImagesDto> findAllImagesByProductId(Long Id);
    List<Product_reviewDto> findAllProduct_reviewByProductId(Long Id);

    List<Product_itemDto> findAllVariationProductByProductId(Long Id);

    ProductDto update_promotion_on_product(Promotion_detailDto dto,Long productid);




}
