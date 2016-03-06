package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.ProductContent;

/**
 * Created by oleg on 05.03.16.
 */
public interface ProductContentDao extends JpaRepository<ProductContent, Integer> {
}
