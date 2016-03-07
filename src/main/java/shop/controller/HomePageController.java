package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by oleg on 05.03.16.
 */
@Controller
public class HomePageController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHomePage(HttpServletRequest request)  {
        ModelAndView modelAndView = new ModelAndView(JspPath.HOME_PAGE);
        modelAndView.addObject("basket", request.getSession().getAttribute("basket"));
        return modelAndView;
    }
}
