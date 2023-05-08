package br.com.m3s01exercicio_semana.m3s01.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Despesa {

    @Id
    @Column(name = "id_despesas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String credor;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(precision = 19, scale = 2, nullable = false)
    private Double valor;

    @Column(columnDefinition = "text")
    private String descricao;

    @Column(nullable = false)
    private String status;
}
