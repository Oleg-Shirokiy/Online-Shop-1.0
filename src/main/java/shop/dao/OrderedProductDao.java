package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.OrderedProduct;

/**
 * Created by oleg on 11.03.16.
 */
public interface OrderedProductDao extends JpaRepository<OrderedProduct, Integer> {
}
