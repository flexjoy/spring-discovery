package com.springapp.mvc;

import com.springapp.Url;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping(Url.LOGIN)
    public void showLoginForm() {}
}
