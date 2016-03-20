package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.OrderedProductDao;
import shop.model.OrderedProduct;
import shop.service.OrderedProductService;

/**
 * Created by oleg on 11.03.16.
 */
@Service
public class OrderedProductServiceImpl extends BaseService<OrderedProduct, OrderedProductDao>
        implements OrderedProductService {
}
