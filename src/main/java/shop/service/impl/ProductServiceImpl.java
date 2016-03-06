package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.ProductDao;
import shop.model.Product;
import shop.service.ProductService;

/**
 * Created by oleg on 05.03.16.
 */
@Service
public class ProductServiceImpl extends BaseService<Product, ProductDao> implements ProductService{
}
