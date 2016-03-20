package shop.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import shop.dao.ProductDao;
import shop.dto.ProductFilter;
import shop.model.Product;
import shop.service.ProductService;


import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Service
public class ProductServiceImpl extends BaseService<Product, ProductDao> implements ProductService{

    public List<Product> getByIdList(List<Integer> idList) {
        return dao.findByIdList(idList);
    }

    public List<Product> getByCode(String vendorCode) {
        return dao.findByCode(vendorCode);
    }

    public Page<Product> getByFilter(ProductFilter filter) {
        Pageable pageRequest = null;
        String sorting = filter.getSorting();
        if (sorting == null || sorting.isEmpty()) {
            pageRequest = new PageRequest(filter.getPage(), filter.getNumber());
        } else if (sorting.equals("ASC")) {
            pageRequest = new PageRequest(filter.getPage(), filter.getNumber(), Direction.ASC, "price");
        } else if (sorting.equals("DESC")) {
            pageRequest = new PageRequest(filter.getPage(), filter.getNumber(), Direction.DESC, "price");
        }
        String availability = filter.getAvailability();
        if (availability == null || availability.isEmpty()) {
            availability = "%";
        }
        String vendor = filter.getVendor();
        Integer category = filter.getCategory();

        if (vendor == null || vendor.isEmpty()) {
            if (category == null) {
                return dao.findByFilter(pageRequest, filter.getSearch(),
                        availability, filter.getMinPrice(), filter.getMaxPrice());
            } else {
                return dao.findByFilter(pageRequest, filter.getSearch(), category,
                        availability, filter.getMinPrice(), filter.getMaxPrice());
            }
        } else {
            if (category == null) {
                return dao.findByFilter(pageRequest, filter.getSearch(), filter.getVendor(),
                        availability, filter.getMinPrice(), filter.getMaxPrice());
            } else {
                return dao.findByFilter(pageRequest, filter.getSearch(), category, filter.getVendor(),
                        availability, filter.getMinPrice(), filter.getMaxPrice());
            }
        }

    }
}
