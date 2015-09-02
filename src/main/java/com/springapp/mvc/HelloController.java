package com.springapp.mvc;

import com.springapp.Person;
import com.springapp.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.*;

@Controller
public class HelloController {

    @Autowired DataSource dataSource;

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
            try {
                Connection conn = dataSource.getConnection();
                String query = String.format("INSERT INTO people (name, age) VALUES ('%s', %d)", person.getName(), person.getAge());
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.execute();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            redirectAttributes.addFlashAttribute(person);
            return "redirect:" + Url.SHOW_PERSON;
        }
    }
}
