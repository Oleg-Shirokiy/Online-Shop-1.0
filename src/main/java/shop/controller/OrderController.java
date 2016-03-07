package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Order;
import shop.service.OrderService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 06.03.16.
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView showOrder(HttpServletRequest request,
                                  @RequestParam(required = true) Integer id) throws SQLException {
        Order order = orderService.getByIdWithProductList(id);
        ModelAndView modelAndView = new ModelAndView(JspPath.ORDER);
        modelAndView.addObject("order", order);
        return modelAndView;
    }
}
