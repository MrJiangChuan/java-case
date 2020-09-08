package com.jc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

            String message = ex.getMessage();

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg",message);
            modelAndView.setViewName("error");

            return modelAndView;
    }
}
