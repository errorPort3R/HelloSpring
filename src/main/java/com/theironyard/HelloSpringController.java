package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jeffryporter on 6/20/16.
 */
@Controller
public class HelloSpringController
{
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String name, String city, Integer age)
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
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        return "person";

    }
}