package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Category;
import shop.model.Product;
import shop.service.CategoryService;
import shop.service.ProductService;
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
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public ModelAndView showProductList(HttpServletRequest request) throws SQLException {
        List<Category> categoryList = categoryService.getAll();
        List<Product> productList = productService.getAll();

        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT_LIST);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));
        return modelAndView;
    }

}
