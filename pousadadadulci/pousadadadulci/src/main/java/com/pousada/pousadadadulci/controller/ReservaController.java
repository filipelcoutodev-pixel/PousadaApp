package com.pousada.pousadadadulci.controller;

import com.pousada.pousadadadulci.model.Reserva;
import com.pousada.pousadadadulci.repository.ReservaRepository;
import jakarta.validation.Valid;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author FilipeLuizCouto
 */
@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping("/reservas/enviar")
    public String criarReserva(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            // Imprime o erro real no console do NetBeans para você ver o culpado
            System.out.println("ERRO DE VALIDAÇÃO: " + result.getAllErrors());
            return "redirect:/?erro=true"; 
        }
        
        if (principal != null) {
            reserva.setUsuario_login(principal.getName());
        }
        
        reserva.setStatus("PENDENTE"); 
        reservaRepository.save(reserva); 
        
        return "redirect:/?sucesso=true"; 
    }

    @GetMapping("/reservas/minhas")
    public String listarMinhasReservas(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login"; 
        }
        
        List<Reserva> minhasReservas = reservaRepository.buscarPorUsuarioLogin(principal.getName());
        model.addAttribute("reservas", minhasReservas);
        return "minhas-reservas"; 
    }
}