package com.springapp.mvc;

import com.springapp.Url;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = Url.HOME_PAGE, method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Привет мир!");
		return "hello";
	}
}
