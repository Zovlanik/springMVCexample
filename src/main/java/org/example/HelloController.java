package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/example")
public class HelloController {

    private UsersCatalog usersCatalog;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/hello.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/param")
    public ModelAndView info2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/hello2.jsp");
        modelAndView.addObject("parameter","My some random parameter");
        return modelAndView;
    }

    @GetMapping(value = "/user/all")
    public ModelAndView allUsers(){

        Collection<UserInfo> users = usersCatalog.getAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/allUsers.jsp");
        modelAndView.addObject("usersList",users);
        return modelAndView;
    }

    @Autowired
    public void setUsersCatalog(UsersCatalog usersCatalog) {
        this.usersCatalog = usersCatalog;
    }
}
