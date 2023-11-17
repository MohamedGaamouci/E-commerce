package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Delevery_time_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Delevery_time_detailRepo extends JpaRepository<Delevery_time_detail ,Long> {
}
