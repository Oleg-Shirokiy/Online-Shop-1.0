package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Order;
import shop.service.OrderService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Controller
public class OrderListController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/admin/orderList", method = RequestMethod.GET)
    public ModelAndView showOrderList(HttpServletRequest request) throws SQLException {
        List<Order> orderList = orderService.getAll();
        ModelAndView modelAndView = new ModelAndView(JspPath.ORDER_LIST);
        modelAndView.addObject("orderList", orderList);
        return modelAndView;
    }
}
