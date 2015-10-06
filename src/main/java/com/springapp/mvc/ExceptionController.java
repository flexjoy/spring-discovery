package com.springapp.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Exception handling controller.
 *
 * Intercept exceptions across the whole application.
 *
 * @author Sergey Cherepanov
 */
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {

        ModelAndView mav = new ModelAndView("error");
        mav.addObject("name", e.getClass().getSimpleName());
        mav.addObject("exception", e);

        return mav;
    }
}
