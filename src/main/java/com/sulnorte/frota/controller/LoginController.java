package com.sulnorte.frota.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private static final String VIEW_HOME = "Menu";
    private static final String ACTION_HOME = "/home";

    @RequestMapping(value = ACTION_HOME)
    public String home(){
        return VIEW_HOME;
    }

}
