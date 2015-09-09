package com.springapp.mvc;

import com.springapp.Person;
import com.springapp.PersonDao;
import com.springapp.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class HelloController {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private MessageSource messageSource;

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
    public String handlePersonForm(@Valid Person person, BindingResult result) throws Exception {
        String view = null; // if errors
        if (!result.hasErrors()){
            long id = personDao.insert(person);
            if (id <= 0)
                throw new Exception(messageSource.getMessage("addPersonError", null, Locale.getDefault()));
            view = String.format("redirect:%s%d", Url.PERSON, id);
        }
        return view;
    }

    @RequestMapping(Url.PERSON + "{id}")
    public String personDetail(@PathVariable(value="id") long id, Model model) throws Exception {
        Person person = personDao.findById(id);
        if (person == null)
            throw new Exception(messageSource.getMessage("personNotExist", null, Locale.getDefault()));
        model.addAttribute("person", person);
        return Url.PERSON + "person";
    }
}
