package com.sulnorte.frota.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    private static final String VIEW_HOME = "menu";
    private static final String ACTION_HOME = "home";

    @RequestMapping(value = ACTION_HOME)
    public String home(){
        return VIEW_HOME;
    }

}
