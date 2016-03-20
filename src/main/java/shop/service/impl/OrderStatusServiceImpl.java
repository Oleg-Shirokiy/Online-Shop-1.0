package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.OrderStatusDao;
import shop.model.OrderStatus;
import shop.service.OrderStatusService;

/**
 * Created by oleg on 11.03.16.
 */
@Service
public class OrderStatusServiceImpl extends BaseService<OrderStatus, OrderStatusDao> implements OrderStatusService {
}
