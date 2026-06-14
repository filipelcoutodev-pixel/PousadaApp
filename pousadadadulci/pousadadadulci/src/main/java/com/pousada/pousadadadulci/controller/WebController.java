package com.pousada.pousadadadulci.controller;

import com.pousada.pousadadadulci.model.Reserva;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class WebController {

    @GetMapping("/")
    public String exibirSitePrincipal(Model model) {
        // Envia um objeto vazio para o formulário do Thymeleaf se mapear
        model.addAttribute("reserva", new Reserva()); 
        return "index"; 
    }
}
