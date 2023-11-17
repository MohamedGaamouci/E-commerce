package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Customers;
import com.gmc_team.e_commerse_platform.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customers ,Long> {
    Customers findByUsername(String userName);
    List<Customers> findByNameAndSecondname(String firstName,String secondName);
    Customers findByEmail(String Email);
    List<Customers> findByGender(String Gender);
//    @Query("select c from Customers c where c.roles in :roleNames")
    List<Customers> findAllByRolesIn( List<Roles> rolesNames);


}
