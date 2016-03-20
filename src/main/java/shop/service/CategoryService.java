package shop.service;

import shop.model.Category;

import java.sql.SQLException;

/**
 * Created by oleg on 05.03.16.
 */
public interface CategoryService extends Service<Category> {
//    @Override
//    Category getById(Integer id) throws SQLException;
    Category getByLevel(Integer level);
    Category getByParentCategoryLevel(Integer level);
    Category getByIdWithAttributeTemplateList(Integer id);
//    Category getByProductWithAttributeTemplateList(Integer id);

}
