package com.pousada.pousadadadulci.controller;

import com.pousada.pousadadadulci.model.Reserva;
import com.pousada.pousadadadulci.repository.ReservaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Controla páginas Thymeleaf
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping("/reservas/enviar")
    public String criarReserva(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result) {
        if (result.hasErrors()) {
            return "index"; // Se faltar algum dado, recarrega a página mostrando o erro
        }
        
        reserva.setStatus("PENDENTE"); 
        reservaRepository.save(reserva); // Salva direto no MySQL!
        
        return "redirect:/?sucesso=true"; // Recarrega a página com o aviso de sucesso na URL
    }
}
