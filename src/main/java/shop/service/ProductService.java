package shop.service;

import shop.model.Product;

import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
public interface ProductService extends Service<Product>{
    List<Product> getByIdList(List<Integer> idList);
}
