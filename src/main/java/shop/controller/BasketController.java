package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.*;
import shop.model.Currency;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by oleg on 05.03.16.
 */
@Controller
public class BasketController {
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/addToBasket", method = RequestMethod.POST)
    public String addToBasket(HttpServletRequest request,
                              @RequestParam(required = true) Integer id,
                              @RequestParam(required = true) Integer number,
                              @RequestParam(required = true) String redirect) throws SQLException {
        HttpSession session = request.getSession();
        Map<Integer, Integer> basket = (Map)session.getAttribute("basket");
        if (basket == null) {
            basket = new LinkedHashMap<>();
            session.setAttribute("basket", basket);
        }
        if (!basket.containsKey(id)) {
            basket.put(id, number);
        } else {
            basket.put(id, basket.get(id) + number);
        }
        return "redirect:" + redirect;
    }

    @RequestMapping(value = "/showBasket", method = RequestMethod.GET)
    public ModelAndView showBasket(HttpServletRequest request) throws SQLException {
        Map<Integer, Integer> basket = (Map)request.getSession().getAttribute("basket");
        List<Integer> idList = new ArrayList<>(basket.keySet());
        List<Product> productList = productService.getByIdList(idList);

        Order order = new Order();
        Integer number = 0;
        Double price = 0.;

        for (Product product : productList) {
            Integer currentNumber = basket.get(product.getId());
            Double currentPrice = product.getPrice();

            number += currentNumber;
            if (currentPrice != null) {
                price += currentPrice * currentNumber;
            }
        }
        order.setTotalPrice(price);
        order.setTotalNumber(number);

        ModelAndView modelAndView = new ModelAndView(JspPath.BASKET);
        modelAndView.addObject("order", order);
        modelAndView.addObject("basket", basket);
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(HttpServletRequest request,
                            @ModelAttribute Order order
    ) throws SQLException {
        String[] iDs = request.getParameterValues("id");
        String[] numbers = request.getParameterValues("number");
        String[] names = request.getParameterValues("name");
        String[] vendorCodes = request.getParameterValues("vendorCode");
        String[] prices = request.getParameterValues("price");
        String[] currencies = request.getParameterValues("currency");
        String[] availStatuses = request.getParameterValues("availability");
        Map<Integer, Integer> basket = (Map)request.getSession().getAttribute("basket");
        List<OrderedProduct> orderedProductList = new ArrayList<>(iDs.length);
        for (int i = 0; i < iDs.length; i++) {
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setProductId(Integer.parseInt(iDs[i]));
            orderedProduct.setNumber(Integer.parseInt(numbers[i]));
            orderedProduct.setName(names[i]);
            orderedProduct.setVendorCode(vendorCodes[i]);
            if (!prices[i].isEmpty() && prices[i] != null) {
                orderedProduct.setPrice(Double.parseDouble(prices[i]));
            }
            orderedProduct.setCurrency(Currency.valueOf(currencies[i]));
            orderedProduct.setAvailability(Availability.valueOf(availStatuses[i]));
            orderedProduct.setOrder(order);
            orderedProductList.add(orderedProduct);
        }
        order.setProductList(orderedProductList);
        orderService.insert(order);
        basket.clear();

        return "redirect:/";
    }


}
