package com.springapp.mvc;

import com.springapp.Person;
import com.springapp.Url;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HelloController {

	@RequestMapping(Url.HOME_PAGE)
	public String showForm(ModelMap model) {
        model.addAttribute("person", new Person());
		return "hello";
	}

    @RequestMapping(Url.SHOW_PERSON)
    public String showPerson(Model model) {
        if (model.asMap().isEmpty())
            return "redirect:" + Url.HOME_PAGE;
        else
            return "result";
    }

    @RequestMapping(value = Url.HOME_PAGE, method = RequestMethod.POST)
    public String handlePersonForm(@Valid Person person, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            return "hello";
        } else {
            redirectAttributes.addFlashAttribute(person);
            return "redirect:" + Url.SHOW_PERSON;
        }
    }
}
