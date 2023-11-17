package com.gmc_team.e_commerse_platform.Repository;
import com.gmc_team.e_commerse_platform.models.Payment_method;
import com.gmc_team.e_commerse_platform.models.Payment_type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Customer_payment_mehtodRepo extends JpaRepository<Payment_method,Long> {
    List<Payment_method> findAllByPaymenttype(Payment_type type);
    List<Payment_method> findAllByProvider(String provider);
    List<Payment_method> findAllByIsdefault(Boolean b);
}
