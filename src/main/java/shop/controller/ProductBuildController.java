package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.dto.ProductDTO;
import shop.model.*;
import shop.service.CategoryService;
import shop.service.ProductContentService;
import shop.service.ProductService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Controller
public class ProductBuildController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductContentService productContentService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/admin/productBuilder", method = RequestMethod.GET)
    public ModelAndView showCategoryBuilder(HttpServletRequest request) throws SQLException {
        List<Category> categoryList = categoryService.getAll();
        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT_BUILDER);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("availabilityEnum", Availability.values());
        modelAndView.addObject("currencyEnum", Currency.values());
        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));
        return modelAndView;
    }

    @RequestMapping(value = "/admin/saveProduct", method = RequestMethod.POST)
    public String saveCategory(HttpServletRequest request,
                               @RequestParam(required = false) Integer categoryID,
                               @ModelAttribute Product product,
                               @ModelAttribute ProductContent productContent) throws SQLException {
        if (categoryID != null) {
            Category category = categoryService.getById(categoryID);
            product.setCategory(category);
        }
        productService.insert(product);
        productContent.setProduct(product);
        productContentService.insert(productContent);
        return "redirect:/admin/productBuilder";
    }

}

