package com.sulnorte.frota.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/porto")
public class PortoController {

    private static final String VIEW_LIST = "porto/List";
    private static final String ACTION_LIST = "/list";
    private static final String VIEW_FORM = "porto/Form";
    private static final String ACTION_CREATE = "/create";

    @RequestMapping(value = ACTION_LIST)
    public String home(){
        return VIEW_LIST;
    }

    @RequestMapping(value = ACTION_CREATE)
    public String prepareCreate(){
        return VIEW_FORM;
    }

}
