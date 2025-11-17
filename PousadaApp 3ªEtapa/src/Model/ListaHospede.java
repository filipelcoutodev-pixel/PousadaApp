
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FilipeLuizCouto
 */
public class ListaHospede {
      
      private static final List<Hospede> lista = new ArrayList<>();

      // acesso a lista e adiciona novos itens
      public static List<Hospede> Listar() {
          return lista;
      }
      
      public static void Adicionar(Hospede hospede) {
          lista.add(hospede);
      }
      
  }
