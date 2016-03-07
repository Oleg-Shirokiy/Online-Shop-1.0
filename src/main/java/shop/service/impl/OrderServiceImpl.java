package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.OrderDao;
import shop.model.Order;
import shop.service.OrderService;

/**
 * Created by oleg on 05.03.16.
 */
@Service
public class OrderServiceImpl extends BaseService<Order, OrderDao> implements OrderService {
    public Order getByIdWithProductList(Integer id) {
        Order order = dao.findOne(id);
        order.getProductList().size();
        return order;
    }
}
