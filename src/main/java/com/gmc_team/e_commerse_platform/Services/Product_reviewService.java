package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Product_reviewDto;

import java.util.List;

public interface Product_reviewService {
    Product_reviewDto findById(Long Id);
    Product_reviewDto save(Product_reviewDto Id);
    List<Product_reviewDto> findAllByRating(Integer rating);
    List<Product_reviewDto> findByProductId(Long Id);
    Product_reviewDto findByCustomerId(Long Id);
    void delete(Long productReviewId);

}
