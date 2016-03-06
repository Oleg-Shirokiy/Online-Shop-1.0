package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Category;
import shop.service.CategoryService;
import shop.util.JspPath;

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

    @RequestMapping(value = "/categoryBuilder", method = RequestMethod.GET)
    public ModelAndView showCategoryBuilder(HttpServletRequest request) throws SQLException {
        List<Category> categoryList = categoryService.getAll();

        ModelAndView modelAndView = new ModelAndView(JspPath.CATEGORY_BUILDER);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveCategory(HttpServletRequest request,
                                @RequestParam(required = true) String name,
                                @RequestParam(required = false) String parentCategoryId) throws SQLException {
        Category category = new Category();
        category.setCategoryName(name);
        if (parentCategoryId != null) {
            Category parentCategory = categoryService.getById(Integer.parseInt(parentCategoryId));
            category.setParentCategory(parentCategory);
        }
        categoryService.insert(category);
        return "redirect:/categoryBuilder";
    }
}
