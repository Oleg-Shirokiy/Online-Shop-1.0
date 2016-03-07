package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Product;
import shop.service.ProductService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by oleg on 05.03.16.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView showCategoryBuilder(HttpServletRequest request,
                                            @RequestParam(required = false) Integer id) throws SQLException {
        Product product = productService.getById(id);
        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT);
        modelAndView.addObject("product", product);
        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));
        return modelAndView;
    }
}
