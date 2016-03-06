package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Category;

/**
 * Created by oleg on 05.03.16.
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
