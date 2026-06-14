/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author FilipeLuizCouto
 */
@Entity
@Table(name = "reserva") // Nome da tabela que o Spring Boot criou no MySQL
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_cliente;
    private String email_Cliente;
    private Date data_entrada;
    private Date data_saida;
    private String observacoes;
    private int qtd_adultos;
    private int qtd_criancas;
    private String status = "PENDENTE"; // Inicia padrão igual na Web

    // Construtor 
    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEmail_Cliente() {
        return email_Cliente;
    }

    public void setEmail_Cliente(String email_Cliente) {
        this.email_Cliente = email_Cliente;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getQtd_adultos() {
        return qtd_adultos;
    }

    public void setQtd_adultos(int qtd_adultos) {
        this.qtd_adultos = qtd_adultos;
    }

    public int getQtd_criancas() {
        return qtd_criancas;
    }

    public void setQtd_criancas(int qtd_criancas) {
        this.qtd_criancas = qtd_criancas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
