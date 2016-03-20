package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.model.Category;

import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category findByLevel(Integer level);
    @Query("select c from categories c where c.parentCategory.level = :level")
    Category findByParentCategoryLevel(@Param("level") Integer level);
    @Query("select c from categories c where c.parentCategory.id = :categoryId")
    List<Category> findByParentCategoryId(@Param("categoryId") Integer categoryId);
}
