package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Product;

/**
 * Created by oleg on 05.03.16.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
}
