package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.CategoryDao;
import shop.model.Category;
import shop.service.CategoryService;

/**
 * Created by oleg on 05.03.16.
 */
@Service
public class CategoryServiceImpl extends BaseService<Category, CategoryDao> implements CategoryService {
}
