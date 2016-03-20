package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.CategoryDao;
import shop.model.AttributeTemplate;
import shop.model.Category;
import shop.model.Product;
import shop.service.CategoryService;

import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Service
public class CategoryServiceImpl extends BaseService<Category, CategoryDao> implements CategoryService {
    public Category getByLevel(Integer level) {
        if (level != 0) {
            return dao.findByLevel(level);
        } else {
            Category rootCategory = dao.findByLevel(level);
            if (rootCategory != null) {
                return rootCategory;
            } else {
                rootCategory = new Category();
                rootCategory.setLevel(0);
                rootCategory.setName("Root category");
                return dao.save(rootCategory);
            }
        }
    }

    public Category getByIdWithAttributeTemplateList(Integer id) {
        Category category = dao.findOne(id);
        List<AttributeTemplate> attributeTemplates = category.getAttributeTemplateList();
        if (attributeTemplates != null) {
            try {
                attributeTemplates.size();
            } catch (org.hibernate.LazyInitializationException ignore) {
                //NOP
            }
        }
            return category;


    }

    public List<Category> getByParentCategoryId(Integer categoryId) {
        return dao.findByParentCategoryId(categoryId);
    }


    public Category getByParentCategoryLevel(Integer level) {
        return dao.findByParentCategoryLevel(level);
    }

}
