package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by oleg on 05.03.16.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * Need for handling not caught anywhere else exceptions
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView(JspPath.DEFAULT_ERROR_VIEW);
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL());

        e.printStackTrace();

        return modelAndView;
    }
}
