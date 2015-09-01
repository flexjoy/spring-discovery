package com.springapp.mvc;

import com.springapp.Person;
import com.springapp.Url;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HelloController {

	@RequestMapping(Url.HOME_PAGE)
	public String printWelcome(ModelMap model) {
        model.addAttribute("person", new Person());
		return "hello";
	}

    @RequestMapping(value = Url.HOME_PAGE, method = RequestMethod.POST)
    public String handlePersonForm(@Valid Person person, BindingResult result, ModelMap model) {
        String view = "result";
        if (result.hasErrors()){
            view = "hello";
        } else {
            model.addAttribute("person", person);
        }
        return view;
    }
}
