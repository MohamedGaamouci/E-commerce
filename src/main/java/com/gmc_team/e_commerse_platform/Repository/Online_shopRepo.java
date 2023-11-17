package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Online_shopRepo extends JpaRepository<Online_shop ,Long> {
    List<Online_shop> findByStorename(String name);
    List<Online_shop> findByStorestatus(Store_status status);
    List<Online_shop> findBySpeciality(Specialities specialities);
    List<Online_shop> findByAnotherspecialtyIgnoreCase(String other);
    List<Online_shop> findByRatingGreaterThanEqualAndRatingLessThanEqual(Float base ,Float haut);
    Online_shop findByStoreowner(Sellers sellers);
    Online_shop findByOnlineshopreviewsContaining(Online_shop_review review);
    Online_shop findByStoredescriptionsContaining(Descriptions descriptions);
}
