package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category ,Long> {
    Category findByName(String Name);
    List<Category> findCategoriesByParentcategory(Category category);
    List<Category> findAllByOnlineshop(Long store);
    void deleteAllByOnlineshop(Long Id);
}
