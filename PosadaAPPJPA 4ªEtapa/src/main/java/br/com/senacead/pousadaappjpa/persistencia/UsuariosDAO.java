
package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.EntityManager;

public class UsuariosDAO {
      public void cadastrar(Usuarios u) {
        EntityManager em = JPAUtil.getEntityManager();
           try {
              em.getTransaction().begin();
              em.persist(u);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEntityManager();
          }
    }
      
    
}
