package shop.service;

import shop.model.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
public interface CategoryService extends Service<Category> {
//    @Override
//    Category getById(Integer id) throws SQLException;
    Category getByLevel(Integer level);
    Category getByParentCategoryLevel(Integer level);
    Category getByIdWithAttributeTemplateList(Integer id);
//    List<Category> getByParentCategory(Category category);
//    Category getByProductWithAttributeTemplateList(Integer id);

}
