package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.ProductContentDao;
import shop.model.Product;
import shop.model.ProductContent;
import shop.service.ProductContentService;

/**
 * Created by oleg on 05.03.16.
 */
@Service
public class ProductContentServiceImpl extends BaseService<ProductContent, ProductContentDao>
        implements ProductContentService {
    public ProductContent getByProduct(Product product) {
        return dao.findByProduct(product);
    }
}
