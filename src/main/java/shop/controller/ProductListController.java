package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.dto.ProductFilter;
import shop.dto.Sorting;
import shop.model.Availability;
import shop.model.Category;
import shop.model.Product;
import shop.model.Vendor;
import shop.service.AvailabilityService;
import shop.service.CategoryService;
import shop.service.ProductService;
import shop.service.VendorService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    AvailabilityService availabilityService;
    @Autowired
    VendorService vendorService;

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public ModelAndView showProductList(HttpServletRequest request,
                                        @RequestParam(required = false) String display,
                                        @RequestParam(required = false) String code) throws SQLException {
        HttpSession session = request.getSession();

        ProductFilter filter = (ProductFilter) session.getAttribute("productFilter");
        if (filter == null) {
            Category category = categoryService.getByLevel(0);
            filter = new ProductFilter();
            filter.setPage(0);
            filter.setNumber(10);
            filter.setCategory(category.getId());
            filter.setAvailability("");
            filter.setSearch("");
            filter.setVendor("");
            filter.setSorting("");
            filter.setMinPrice(0.);
            filter.setMaxPrice(100000.);

            session.setAttribute("productFilter", filter);
        }


        if (display != null) {
            if (display.equals("allProducts")) {
                filter.setCategory(null);
            } else if (display.equals("byCategories")) {
                filter.setCategory(categoryService.getByLevel(0).getId());

            }
        }
        List<Category> categoryList = categoryService.getByParentCategoryId(filter.getCategory());

        ModelAndView modelAndView = new ModelAndView(JspPath.PRODUCT_LIST);

        if (code != null) {
            List<Product> productList = productService.getByCode(code);
            modelAndView.addObject("productList", productList);
        } else {
            Page<Product> productPage = productService.getByFilter(filter);
            modelAndView.addObject("productPage", productPage);
            modelAndView.addObject("productList", productPage.getContent());
        }

        List<Availability> availabilityList = availabilityService.getAll();
        List<Vendor> vendorList = vendorService.getAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("availabilityList", availabilityList);
        modelAndView.addObject("vendorList", vendorList);

        modelAndView.addObject("basket", session.getAttribute("basket"));
        modelAndView.addObject("filter", filter);

        modelAndView.addObject("sortingEnum", Sorting.values());



        return modelAndView;
    }

    @RequestMapping(value = "/doFilter", method = RequestMethod.GET)
    public String doFilter(HttpServletRequest request,
                           @ModelAttribute ProductFilter filterDTO) {
        request.getSession().setAttribute("productFilter", filterDTO);
        return "redirect:/productList";
    }

    @RequestMapping(value = "/goTo", method = RequestMethod.GET)
    public String goToCategory(HttpServletRequest request,
                               @RequestParam(required = true) Integer category) {
        ProductFilter filter = (ProductFilter) request.getSession().getAttribute("productFilter");
        filter.setCategory(category);
        return "redirect:/productList";
    }
}
