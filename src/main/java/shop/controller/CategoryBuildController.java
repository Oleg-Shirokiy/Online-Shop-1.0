package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.model.AttributeTemplate;
import shop.model.Category;
import shop.service.AttributeTemplateService;
import shop.service.CategoryService;
import shop.util.JspPath;
import shop.util.Messages;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Controller
public class CategoryBuildController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    AttributeTemplateService attributeTemplateService;

    /**
     * It allows to view category builder page
     * @param request - need to save basket through the session.
     * @param id - category id to show page in edit mode.
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/categoryBuilder", method = RequestMethod.GET)
    public ModelAndView showCategoryBuilder(HttpServletRequest request,
                                            @RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.CATEGORY_BUILDER);

        List<Category> categoryList = categoryService.getAll();
        modelAndView.addObject("categoryList", categoryList);
        List<AttributeTemplate> attributeTemplateList = attributeTemplateService.getAll();
        modelAndView.addObject("attributeTemplateList", attributeTemplateList);


        if (id != null) {
            Category category = categoryService.getByIdWithAttributeTemplateList(id);
            modelAndView.addObject("category", category);
        }

        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));
        return modelAndView;
    }

    /**
     * It allows to create new category or update existing.
     * @param categoryId -  the existed category will be updated if id present.
     *                   The new category will by created if id absent.
     * @param name - name of the category
     * @param parentCategoryId - null value is equivalent of the id of root category
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/saveCategory", method = RequestMethod.POST)
    public String saveCategory( @RequestParam(required = false) Integer categoryId,
                                @RequestParam(required = true) String name,
                                @RequestParam(required = false) Integer parentCategoryId
    ) throws SQLException {
        Category parentCategory = null;
        if (parentCategoryId != null) {
            parentCategory = categoryService.getById(parentCategoryId);
        } else {
            parentCategory = categoryService.getByLevel(0);
        }

        Category category;
        if (categoryId != null) {
            category = categoryService.getById(categoryId);
            category.setName(name);
            category.setParentCategory(parentCategory);
            category.setLevel(parentCategory.getLevel()+1);
            categoryService.update(category);
        } else {
            category = new Category();
            category.setName(name);
            category.setParentCategory(parentCategory);
            category.setLevel(parentCategory.getLevel()+1);
            categoryService.insert(category);
        }

        return "redirect:/admin/categoryBuilder?id=" + category.getId();
    }

    /**
     * It allows to snap the attribute templates to category or edit already snapped.
     * @param categoryId
     * @param attributeTemplateId -  the existed attribute template will be updated if id present.
     *                   The new template will by created if id absent.
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/snapAttributeTemplate", method = RequestMethod.POST)
    public String snapAttributeTemplate(@RequestParam(required = true) Integer categoryId,
                                        @RequestParam(required = true) Integer attributeTemplateId
    ) throws SQLException {
        AttributeTemplate attributeTemplate = attributeTemplateService.getById(attributeTemplateId);
        Category category = categoryService.getById(categoryId);
        List<AttributeTemplate> attributeTemplateList = category.getAttributeTemplateList();
        attributeTemplateList.add(attributeTemplate);
        categoryService.update(category);
        return "redirect:/admin/categoryBuilder?id=" + category.getId();
    }
    @RequestMapping(value = "admin/deleteCategory", method = RequestMethod.POST)
    public String deleteCategory(@RequestParam(required = true) Integer categoryId) throws SQLException {
        Category category = categoryService.getById(categoryId);
        try {
            categoryService.delete(category);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/productList?message=" + Messages.FAILED_DELETE_CATEGORY;
        }

        return "redirect:/productList";
    }
}
