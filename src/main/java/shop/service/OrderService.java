package shop.service;

import shop.model.Order;

/**
 * Created by oleg on 05.03.16.
 */
public interface OrderService extends Service<Order> {
    Order getByIdWithProductList(Integer id);
}
