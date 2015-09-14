package com.springapp.mvc;

import com.springapp.model.Person;
import com.springapp.dao.PersonDao;
import com.springapp.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

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
        model.addAttribute("personList", personDao.selectAll());
    }

    @RequestMapping(Url.ADD_PERSON)
    public void showForm(ModelMap model) {
        model.addAttribute("person", new Person());
    }

    @RequestMapping(value = Url.ADD_PERSON, method = RequestMethod.PUT)
    public String handlePersonForm(@Valid Person person, BindingResult result) {
        String view = null; // if errors
        if (!result.hasErrors()){
            long id = personDao.insert(person);
            String dstUrl = UriComponentsBuilder
                    .fromUriString(Url.PERSON)
                    .buildAndExpand(id)
                    .toString();
            view = "redirect:" + dstUrl;
        }
        return view;
    }

    @RequestMapping(Url.PERSON)
    public String personDetail(@PathVariable("id") long id, Model model) {
        Person person = personDao.findById(id);
        model.addAttribute("person", person);
        String view = UriComponentsBuilder
                .fromUriString(Url.PERSON)
                .buildAndExpand("person")
                .toString();
        return view;
    }

    // Confirm delete person when JavaScript is disabled
    @RequestMapping(Url.CONFIRM_DELETE)
    public String confirmDelete(@PathVariable("id") long id) {
        return "confirmDelete";
    }

    @RequestMapping(value = Url.DELETE_PERSON, method = RequestMethod.DELETE)
    public String deletePerson(long id) {
        personDao.delete(id);
        return "redirect:" + Url.SHOW_PERSON;
    }

    @RequestMapping(Url.EDIT_PERSON)
    public String editPerson(@PathVariable("id") long id, Model model) {
        Person person = personDao.findById(id);
        model.addAttribute("person", person);
        return "/person/edit";
    }

    @RequestMapping(value = Url.EDIT_PERSON, method = RequestMethod.POST)
    public String handleEditForm(@PathVariable("id") long id, @Valid Person person, BindingResult result) {
        String view = "/person/edit"; // if errors
        if (!result.hasErrors()) {
            personDao.edit(person);
            String dstUrl = UriComponentsBuilder
                    .fromUriString(Url.PERSON)
                    .buildAndExpand(id)
                    .toString();
            view = "redirect:" + dstUrl;
        }
        return view;
    }
}
