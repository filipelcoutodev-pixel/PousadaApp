package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "caixa") // Nome da tabela no banco MySQL
public class Caixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private double entradas;
    private double gastos;
    private double saldoTotal;

    public Caixa() {
    }

    public Caixa(double entradas, double gastos) {
        this.entradas = entradas;
        this.gastos = gastos;
        this.saldoTotal = entradas - gastos;
    }

    // Getters e Setters
    public double getEntradas() {
        return entradas;
    }

    public void setEntradas(double entradas) {
        this.entradas = entradas;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

}
