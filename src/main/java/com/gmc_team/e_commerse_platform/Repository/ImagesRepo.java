package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesRepo extends JpaRepository<Images ,Long> {
    List<Images> findAllByTitle(String title);
    List<Images> findAllByURL(String url);
}
