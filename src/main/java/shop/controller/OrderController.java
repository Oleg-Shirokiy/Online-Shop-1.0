package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.Order;
import shop.model.OrderStatus;
import shop.service.OrderService;
import shop.service.OrderStatusService;
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
    @Autowired
    OrderStatusService orderStatusService;

    /**
     * It allows to view order page
     * @param id - identifier of the order
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView showOrder(@RequestParam(required = true) Integer id) throws SQLException {
        Order order = orderService.getByIdWithProductList(id);
        ModelAndView modelAndView = new ModelAndView(JspPath.ORDER);
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    /**
     * It allows to show the list of orders
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/orderList", method = RequestMethod.GET)
    public ModelAndView showOrderList() throws SQLException {
        List<Order> orderList = orderService.getAll();
        List<OrderStatus> orderStatusList = orderStatusService.getAll();
        ModelAndView modelAndView = new ModelAndView(JspPath.ORDER_LIST);
        modelAndView.addObject("orderList", orderList);
        modelAndView.addObject("orderStatusList", orderStatusList);
        return modelAndView;
    }
    @RequestMapping(value = "/admin/changeOrderStatus", method = RequestMethod.POST)
    public String changeOrderStatus(@RequestParam(required = true) Integer orderId,
                                    @RequestParam(required = true) Integer orderStatusId) throws SQLException {
        Order order = orderService.getById(orderId);
        OrderStatus orderStatus = orderStatusService.getById(orderStatusId);
        order.setOrderStatus(orderStatus);
        orderService.update(order);
        return "redirect:/admin/orderList";
    }

}
