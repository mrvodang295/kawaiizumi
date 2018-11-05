/**
 * 
 */
package com.izumi.product.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author vle28
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler({ Exception.class, RuntimeException.class})
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		LOGGER.error(this.getClass().getSimpleName() + "- An exception throw from URL: {}", req.getRequestURL(), ex);
		ModelAndView mov = new ModelAndView();
		mov.addObject("msg", "Sorry, we couldn't find what you are looking for." + ex.getMessage());
		mov.addObject("url", req.getRequestURL());
		mov.setViewName("404");
		
		return mov;
	}

}
