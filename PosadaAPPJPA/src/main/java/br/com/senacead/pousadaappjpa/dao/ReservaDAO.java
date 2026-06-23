/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senacead.pousadaappjpa.dao;

import br.com.senacead.pousadaappjpa.utilitarios.JPAUtil;
import br.com.senacead.pousadaappjpa.persistencia.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author FilipeLuizCouto
 */
public class ReservaDAO {

// Usa o padrão padrão do seu projeto através do JPAUtil
    private EntityManager em = JPAUtil.getEntityManager();

    // Busca todas as reservas registradas na Web
  // Busca todas as reservas registradas na Web limpando o cache
    public List<Reserva> listarTodas() {
        try {
            // Limpa o cache para ler os dados novos gravados pela Web
            em.clear(); 
            return em.createQuery("SELECT r FROM Reserva r ORDER BY r.id DESC", Reserva.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao listar reservas no DAO: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Altera o status da reserva para APROVADO
    public void aprovar(Long id) {
        try {
            em.getTransaction().begin();
            Reserva reserva = em.find(Reserva.class, id);
            if (reserva != null) {
                reserva.setStatus("APROVADO");
                em.merge(reserva);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    // Remove a reserva caso o cliente não envie o sinal
    public boolean excluir(Long id) {
        try {
            em.getTransaction().begin();
            Reserva reserva = em.find(Reserva.class, id);
            if (reserva != null) {
                em.remove(reserva);
                em.getTransaction().commit();
                return true;
            }
            em.getTransaction().rollback();
            return false;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
}
