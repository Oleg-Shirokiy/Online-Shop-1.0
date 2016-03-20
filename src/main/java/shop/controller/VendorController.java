package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Vendor;
import shop.service.VendorService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 18.03.16.
 */
@Controller
public class VendorController {
    @Autowired
    VendorService vendorService;

    @RequestMapping(value = "/admin/vendors", method = RequestMethod.GET)
    public ModelAndView showVendorList(HttpServletRequest request,
                                     @RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.VENDORS);

        List<Vendor> vendorList = vendorService.getAll();
        modelAndView.addObject("vendorList", vendorList);

        if (id != null) {
            Vendor vendor = vendorService.getById(id);
            modelAndView.addObject("vendor", vendor);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/admin/saveVendor", method = RequestMethod.POST)
    public String saveCurrency(HttpServletRequest request,
                               @ModelAttribute Vendor vendor) throws SQLException {
        if (vendor.getId() == null) {
            vendorService.insert(vendor);
        } else {
            vendorService.update(vendor);
        }
        return "redirect:/admin/vendors";
    }

}
