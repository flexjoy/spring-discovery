package com.springapp.mvc;

import com.springapp.Person;
import com.springapp.PersonDao;
import com.springapp.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HelloController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping(Url.HOME_PAGE)
    public String rootRedirect(){
        return "redirect:" + Url.SHOW_PERSON;
    }

    @RequestMapping(Url.SHOW_PERSON)
    public void showPerson(Model model) {
        String view = Url.SHOW_PERSON;
        model.addAttribute("personList", personDao.selectAll());
    }

    @RequestMapping(Url.ADD_PERSON)
    public void showForm(ModelMap model) {
        model.addAttribute("person", new Person());
    }

    @RequestMapping(value = Url.ADD_PERSON, method = RequestMethod.POST)
    public String handlePersonForm(@Valid Person person, BindingResult result) {
        String view = null; // if errors
        if (!result.hasErrors()){
            personDao.insert(person);
            view = "redirect:" + Url.SHOW_PERSON;
        }
        return view;
    }
}
