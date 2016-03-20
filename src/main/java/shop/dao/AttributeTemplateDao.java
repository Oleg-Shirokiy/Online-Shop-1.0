package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.model.AttributeTemplate;
import shop.model.Category;

import java.util.List;

/**
 * Created by oleg on 11.03.16.
 */
public interface AttributeTemplateDao extends JpaRepository<AttributeTemplate, Integer> {
//    @Query("select at from attribute_templates at where at.category")
//    List<AttributeTemplate> findByCategory(@Param("category") Category category);
}
