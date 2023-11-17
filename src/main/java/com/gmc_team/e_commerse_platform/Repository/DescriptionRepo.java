package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Descriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptionRepo extends JpaRepository<Descriptions ,Long> {
    List<Descriptions> findAllByTitle(String Title);
    List<Descriptions> findAllByOnlineshop(Long Id);

}
