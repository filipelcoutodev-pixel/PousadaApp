/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FilipeLuizCouto
 */
public class ListaGastos {
          // Declaração de variáveis
      private static final List<Gastos> listaGastos = new ArrayList<>();

      // Métodos para acessarmos a lista e adicionarmos novos itens
      public static List<Gastos> Listar() {
          return listaGastos;
      }
      
      public static void Adicionar(Gastos gastos) {
          listaGastos.add(gastos);
      }
}
