package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Product;
import shop.model.ProductContent;
import shop.service.ProductContentService;
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
    @Autowired
    ProductContentService productContentService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView showProductBuilder(HttpServletRequest request,
                                            @RequestParam(required = false) Integer id) throws SQLException {
        Product product = productService.getById(id);
        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT);
        modelAndView.addObject("product", product);
        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));
        return modelAndView;
    }

    public String editProduct(HttpServletRequest request,
                              @RequestParam(required = true) Integer id) {

        return "redirect:/admin/productBuilder?id=" + id;
    }

    public String deleteProduct(HttpServletRequest request,
                                @RequestParam(required = true) Integer id) throws SQLException {
        Product product = productService.getById(id);
        ProductContent productContent = productContentService.getByProduct(product);
        productContentService.delete(productContent);
        productService.delete(product);
        return "redirect:/productList";
    }
}
