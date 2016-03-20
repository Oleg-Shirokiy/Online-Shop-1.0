package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Availability;
import shop.model.Currency;
import shop.model.OrderStatus;
import shop.service.AvailabilityService;
import shop.service.CurrencyService;
import shop.service.OrderStatusService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 11.03.16.
 */
@Controller
public class SettingsPageController {
    @Autowired
    AvailabilityService availabilityService;
    @Autowired
    OrderStatusService orderStatusService;
    @Autowired
    CurrencyService currencyService;

    @RequestMapping(value = "/admin/settings", method = RequestMethod.GET)
    public ModelAndView showSettings(HttpServletRequest request,
                                     @RequestParam(required = false) Integer availabilityId,
                                     @RequestParam(required = false) Integer orderStatusId,
                                     @RequestParam(required = false) Integer currencyId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.SETTINGS);

        List<Availability> availabilityList = availabilityService.getAll();
        List<OrderStatus> orderStatusList = orderStatusService.getAll();
        List<Currency> currencyList = currencyService.getAll();

        modelAndView.addObject("availabilityList", availabilityList);
        modelAndView.addObject("orderStatusList", orderStatusList);
        modelAndView.addObject("currencyList", currencyList);

        if (availabilityId != null) {
            Availability availability = availabilityService.getById(availabilityId);
            modelAndView.addObject("availability", availability);
        }
        if (orderStatusId != null) {
            OrderStatus orderStatus  = orderStatusService.getById(orderStatusId);
            modelAndView.addObject("orderStatus", orderStatus);
        }
        if (currencyId != null) {
            Currency currency = currencyService.getById(currencyId);
            modelAndView.addObject("currency", currency);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/admin/saveAvailabilityStatus", method = RequestMethod.POST)
    public String saveAvailabilityStatus(HttpServletRequest request,
                                         @RequestParam(required = false) Integer id,
                                         @ModelAttribute Availability availability) throws SQLException {
        if (id != null) {
            availabilityService.update(availability);
        } else {
            availabilityService.insert(availability);
        }
        return "redirect:/admin/settings";
    }

    @RequestMapping(value = "/admin/saveCurrency", method = RequestMethod.POST)
    public String saveCurrency(HttpServletRequest request,
                              @ModelAttribute Currency currency,
                              @RequestParam(required = false) Integer id) throws SQLException {
        if (id == null) {
            currencyService.insert(currency);
        } else {
            currencyService.update(currency);
        }
        return "redirect:/admin/settings";
    }

    @RequestMapping(value = "/admin/saveOrderStatus", method = RequestMethod.POST)
    public String saveOrderStatus(HttpServletRequest request,
                                 @ModelAttribute OrderStatus orderStatus,
                                 @RequestParam(required = false) Integer id) throws SQLException {
        if (id == null) {
            orderStatusService.insert(orderStatus);
        } else {
            orderStatusService.update(orderStatus);
        }
        return "redirect:/admin/settings";
    }



}
