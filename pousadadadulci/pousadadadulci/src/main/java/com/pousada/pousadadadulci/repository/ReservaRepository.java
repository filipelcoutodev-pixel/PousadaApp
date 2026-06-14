/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pousada.pousadadadulci.repository;

import com.pousada.pousadadadulci.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FilipeLuizCouto
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // Aqui moram os comandos automáticos para salvar no banco de dados
}
