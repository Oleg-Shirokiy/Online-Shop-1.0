package shop.service;

import shop.model.Product;
import shop.model.ProductContent;

/**
 * Created by oleg on 05.03.16.
 */
public interface ProductContentService extends Service<ProductContent> {
    ProductContent getByProduct(Product product);
}
