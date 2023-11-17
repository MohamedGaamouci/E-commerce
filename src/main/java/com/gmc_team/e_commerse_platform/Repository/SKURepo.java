package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.SKU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SKURepo extends JpaRepository<SKU,Long>{
    List<SKU> findByNameStartingWith(String Name);
    SKU findByNameEqualsIgnoreCase(String Name);
    List<SKU> findByNameContainingIgnoreCase(String Name);
}
