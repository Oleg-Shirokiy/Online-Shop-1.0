package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Order;

/**
 * Created by oleg on 05.03.16.
 */
public interface OrderDao extends JpaRepository<Order, Integer> {
}
