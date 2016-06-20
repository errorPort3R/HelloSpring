package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by jeffryporter on 6/20/16.
 */
@Controller
public class HelloSpringController
{

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String name, String city, Integer age, HttpSession session)
    {
        if (name== null)
        {
            name = "Alice";
        }
        if (city== null)
        {
            city = "Newark";
        }
        if (age == null)
        {
            age = 35;
        }

        String username = (String)session.getAttribute("username");
        User user = null;
        if (username != null)
        {
            user = new User(username);
        }
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        model.addAttribute("user",user);
        return "person";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, HttpSession session)
    {
        session.setAttribute("username",username);

        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }


}
