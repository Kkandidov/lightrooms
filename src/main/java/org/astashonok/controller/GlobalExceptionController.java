package org.astashonok.controller;

import org.astashonok.exception.RoomNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;


@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException(HttpServletResponse response, NoHandlerFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("errorTitle", "The page is not constructed!");
        modelAndView.addObject("errorDescription", "The page you are looking for is not "
                + "available now!");
        modelAndView.addObject("title", "404 Error Page");
        modelAndView.addObject("errorThrown", true);
        return modelAndView;
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ModelAndView handlerRoomNotFoundException() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("errorTitle", "Room is not available!");
        modelAndView.addObject("errorDescription", "The room you are looking for is not "
                + "available right now!");
        modelAndView.addObject("title", "Product Unavailable");
        modelAndView.addObject("errorThrown", true);
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("page");

        // for debugging
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);

        modelAndView.addObject("errorTitle", "Contact Your Administrator!");
        modelAndView.addObject("errorDescription", stringWriter.toString());
        modelAndView.addObject("title", "Error");
        modelAndView.addObject("errorThrown", true);
        return modelAndView;
    }
}
