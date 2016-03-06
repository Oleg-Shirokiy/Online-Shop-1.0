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
public class ProductListController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public ModelAndView writeTo(HttpServletRequest request) throws SQLException {
        List<Category> categoryList = categoryService.getAll();

        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT_LIST);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

}
