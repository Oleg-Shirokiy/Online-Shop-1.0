package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.OrderStatus;

/**
 * Created by oleg on 11.03.16.
 */
public interface OrderStatusDao extends JpaRepository<OrderStatus, Integer> {
}
