package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findCustomer_ordersByOrderstatus(Order_status status);
    List<Order> findAllByShippingMethod(Shipping_method Id);
    List<Order> findAllByCustomerid(Long Id);
    List<Order> findAllByShippingaddress(Address Id);
    List<Order> findAllByPaymentmethod(Payment_method Id);
    Order findByReview(Order_review Id);

}
