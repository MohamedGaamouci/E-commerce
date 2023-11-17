package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Roles;
import com.gmc_team.e_commerse_platform.models.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepo extends JpaRepository<Sellers ,Long> {
    List<Sellers>findAllByFirstnameAndSecondname(String f_name ,String s_name);
    List<Sellers>findAllByGender(String gender);
    List<Sellers>findAllByRolesIn(List<Roles> rolesNames);
    Sellers findByUsername(String name);
    Sellers findByEmail(String Email);

}
