package com.fiap.locatech.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Pessoa {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
}
