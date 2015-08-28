package com.springapp.mvc;

import com.springapp.Url;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(Url.HOME_PAGE)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Привет мир!");
		return "hello";
	}
}
