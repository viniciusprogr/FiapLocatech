package com.fiap.locatech.entities;

import com.fiap.locatech.dtos.AluguelRequestDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {
    private Long id;
    private long pessoaId;
    private long veiculoId;
    private String veiculoModelo;
    private String pessoaCpf;
    private String pessoaNome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;


    public Aluguel(AluguelRequestDTO aluguelDTO, BigDecimal valor) {
        this.pessoaId = aluguelDTO.pessoaId();
        this.veiculoId = aluguelDTO.veiculoId();
        this.dataInicio = aluguelDTO.dataInicio();
        this.dataFim = aluguelDTO.dataFim();
        this.valorTotal = valor;
    }
}
