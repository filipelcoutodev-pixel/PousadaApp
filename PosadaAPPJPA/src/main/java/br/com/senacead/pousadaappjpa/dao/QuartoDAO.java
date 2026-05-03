/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senacead.pousadaappjpa.dao;

import br.com.senacead.pousadaappjpa.Utilitaria.JPAUtil;
import br.com.senacead.pousadaappjpa.persistencia.Quarto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author FilipeLuizCouto
 */
public class QuartoDAO {
    
       // Buscar quarto por ID
    public Quarto buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Quarto.class, id);
        } finally {
            em.close();
        }
    }
    
        // Buscar quarto por identificação 
    public Quarto buscarQuartoPorIdentificacao(String identificacao) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        // Se vier "Quarto 1", "Quarto 2", etc., remove o prefixo
        if (identificacao.startsWith("Quarto ")) {
            identificacao = identificacao.replace("Quarto ", "");
        }

        TypedQuery<Quarto> query = em.createQuery(
            "SELECT q FROM Quarto q WHERE q.identificacao = :ident", Quarto.class);
        query.setParameter("ident", identificacao);

        List<Quarto> resultados = query.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    } finally {
        em.close();
    }
}

    
       // Listar todos os quartos
    public List<Quarto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT q FROM Quarto q", Quarto.class).getResultList();
        } finally {
            em.close();
        }
    }
    
       // Cadastrar novo quarto
    public void cadastrar(Quarto quarto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(quarto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
      // Atualizar quarto existente
    public void atualizar(Quarto quarto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(quarto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
      // Excluir quarto por ID
    public boolean excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Quarto quarto = em.find(Quarto.class, id);
            if (quarto != null) {
                em.getTransaction().begin();
                em.remove(quarto);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
