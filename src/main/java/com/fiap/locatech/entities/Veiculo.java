package com.fiap.locatech.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private String ano;
    private String cor;
    private BigDecimal  valorDiaria;
}
