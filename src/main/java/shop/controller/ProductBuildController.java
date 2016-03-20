package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.*;
import shop.service.*;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    @Autowired
    CurrencyService currencyService;
    @Autowired
    AvailabilityService availabilityService;
    @Autowired
    VendorService vendorService;

    /**
     * It allows to view product builder page.
     * @param request - need to save basket through the session.
     * @param id - product id to show page in edit mode.
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/productBuilder", method = RequestMethod.GET)
    public ModelAndView showProductBuilder(HttpServletRequest request,
                                            @RequestParam(required = false) Integer id) throws SQLException {
        List<Category> categoryList = categoryService.getAll();
        List<Availability> availabilityList = availabilityService.getAll();
        List<Currency> currencyList = currencyService.getAll();
        List<Vendor> vendorList = vendorService.getAll();

        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT_BUILDER);

        if (id != null) {
            Product product = productService.getById(id);
            modelAndView.addObject("product", product);
            ProductContent productContent = productContentService.getByProduct(product);
            modelAndView.addObject("productContent", productContent);
        }

        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("availabilityList", availabilityList);
        modelAndView.addObject("currencyList", currencyList);
        modelAndView.addObject("vendorList", vendorList);
        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));

        return modelAndView;
    }

    /**
     * It allows to create new product or update already existing
     * @param categoryID -  the existed product will be updated if id present.
     *                   The new product will by created if id absent.
     * @param availabilityID
     * @param currencyID
     * @param vendorID
     * @param product
     * @param productContent
     * @return
     * @throws SQLException
     * @throws IOException
     */
    @RequestMapping(value = "/admin/saveProduct", method = RequestMethod.POST)
    public String saveProduct(
                               @RequestParam(required = false) Integer categoryID,
                              @RequestParam(required = true) Integer availabilityID,
                              @RequestParam(required = true) Integer currencyID,
                              @RequestParam(required = true) Integer vendorID,
                               @ModelAttribute Product product,
                               @ModelAttribute ProductContent productContent) throws SQLException, IOException {
        Category category = null;
        if (categoryID != null) {
            category = categoryService.getById(categoryID);
        } else {
            category = categoryService.getByLevel(0);
        }
        product.setCategory(category);

        Availability availability = availabilityService.getById(availabilityID);
        product.setAvailability(availability);
        Currency currency = currencyService.getById(currencyID);
        product.setCurrency(currency);
        Vendor vendor = vendorService.getById(vendorID);
        product.setVendor(vendor);


        if (product.getId() == null) {
            productService.insert(product);
            productContent.setProduct(product);
            productContentService.insert(productContent);
        } else {
            productService.update(product);
            productContentService.update(productContent);
        }
        return "redirect:/admin/productBuilder?id=" + product.getId();
    }

}

