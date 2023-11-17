package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Order_lineDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Order_lineService {
    Order_lineDto findById(Long Id);
    Order_lineDto save(Order_lineDto Id);

    List<Order_lineDto> findByProduct(Long productId);

    Order_lineDto cancelOrderLines(Order_lineDto line);

}
