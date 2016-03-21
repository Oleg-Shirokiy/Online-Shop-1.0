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

    /**
     * It allows to view product page
     * @param request  - need to save basket through the session.
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView showProduct(HttpServletRequest request,
                                            @RequestParam(required = false) Integer id) throws SQLException {
        Product product = productService.getById(id);
        ProductContent productContent = productContentService.getByProduct(product);
        String[] imageLinks = productContent.getImageLinks().split(",");

        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT);
        modelAndView.addObject("product", product);
        modelAndView.addObject("productContent", productContent);
        modelAndView.addObject("imageLinks", imageLinks);
        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));
        return modelAndView;
    }
    @RequestMapping(value = "admin/deleteProduct", method = RequestMethod.POST)
    public String deleteProduct(@RequestParam(required = true) Integer id) throws SQLException {
        Product product = productService.getById(id);
        ProductContent productContent = productContentService.getByProduct(product);
        productContentService.delete(productContent);
        productService.delete(product);
        return "redirect:/productList";
    }
}
