package shop.service;

import org.springframework.data.domain.Page;
import shop.dto.ProductFilter;
import shop.model.Product;

import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
public interface ProductService extends Service<Product>{
    List<Product> getByIdList(List<Integer> idList);
    List<Product> getByCode(String vendorCode);
    Page<Product> getByFilter(ProductFilter filter);
}
