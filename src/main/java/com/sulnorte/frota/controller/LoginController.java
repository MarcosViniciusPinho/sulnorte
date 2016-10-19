package com.sulnorte.frota.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe que efetua o login do usuário e o redireciona para a tela principal
 */
@Controller
public class LoginController {

    private static final String VIEW_HOME = "Menu";
    private static final String ACTION_HOME = "/";

    /**
     * Método que redireciona o usuário para a tela principal
     * @return String
     */
    @RequestMapping(value = ACTION_HOME)
    public String home(){
        return VIEW_HOME;
    }

}
