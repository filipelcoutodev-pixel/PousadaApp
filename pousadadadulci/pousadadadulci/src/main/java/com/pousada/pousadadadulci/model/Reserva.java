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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// 4. IMPORTANTE: Adicionado o import de data do Java
import java.time.LocalDate;

/**
 *
 * @author FilipeLuizCouto
 */
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome do cliente é obrigatório.")
    @Column(name = "nome_cliente", nullable = false, length = 150)
    private String nomeCliente;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Insira um e-mail válido.")
    @Column(name = "email_cliente", nullable = false, length = 100)
    private String emailCliente;

    @NotNull(message = "A data de entrada é obrigatória.")
    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    @NotNull(message = "A data de saída é obrigatória.")
    @Column(name = "data_saida", nullable = false)
    private LocalDate dataSaida;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    @NotNull(message = "A quantidade de adultos deve ser informada.")
    @Min(value = 1, message = "A reserva deve ter pelo menos 1 adulto.")
    @Column(name = "qtd_adultos", nullable = false)
    private Integer qtdAdultos;

    @NotNull(message = "A quantidade de crianças deve ser informada.")
    @Min(value = 0, message = "A quantidade de crianças não pode ser negativa.")
    @Column(name = "qtd_criancas", nullable = false)
    private Integer qtdCriancas;

    @NotBlank(message = "O status da reserva é obrigatório.")
    @Column(name = "status", nullable = false, length = 30)
    private String status = "PENDENTE"; // Inicia automaticamente como pendente para aprovação

    public Reserva() {
    }
    
    // Getters e Setters manuais para evitar falhas de compilação

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getQtdAdultos() {
        return qtdAdultos;
    }

    public void setQtdAdultos(Integer qtdAdultos) {
        this.qtdAdultos = qtdAdultos;
    }

    public Integer getQtdCriancas() {
        return qtdCriancas;
    }

    public void setQtdCriancas(Integer qtdCriancas) {
        this.qtdCriancas = qtdCriancas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
