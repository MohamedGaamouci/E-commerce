package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepo  extends JpaRepository<Administrators ,Long> {
    Administrators findByUsername(String username);
    List<Administrators> findAllByFirstNameAndSecondName(String firstName ,String secondName);
    Administrators findByEmail(String Email);
}
