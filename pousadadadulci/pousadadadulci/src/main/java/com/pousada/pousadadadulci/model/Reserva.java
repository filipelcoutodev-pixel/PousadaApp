/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pousada.pousadadadulci.model;

// 1. IMPORTANTE: Adicionados os imports do Jakarta Persistence (JPA)
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

// 2. IMPORTANTE: Adicionados os imports das validações de dados
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

// 3. IMPORTANTE: Adicionados os imports das ferramentas do Lombok



// 4. IMPORTANTE: Adicionado o import de data do Java
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author FilipeLuizCouto
 */
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome_cliente;
    private String email_Cliente;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Evita erro de conversão HTML -> Java
    private Date data_entrada;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Evita erro de conversão HTML -> Java
    private Date data_saida;
    
    private String observacoes;
    private int qtd_adultos;
    private int qtd_criancas;
    private String status = "PENDENTE";
    private String usuario_login; 

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

    public String getUsuario_login() {
        return usuario_login;
    }

    public void setUsuario_login(String usuario_login) {
        this.usuario_login = usuario_login;
    }
    
    
}