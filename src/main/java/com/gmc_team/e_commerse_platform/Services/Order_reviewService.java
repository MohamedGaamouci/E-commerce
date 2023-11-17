package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Order_reviewDto;

import java.util.List;

public interface Order_reviewService {
    Order_reviewDto save(Order_reviewDto Id);
    Order_reviewDto findById(Long Id);
    Order_reviewDto findByCustomer_id(Long Id);
    List<Order_reviewDto> findByRating(Integer rating);
    Order_reviewDto findByCustomer_orderId(Long Id);

}
