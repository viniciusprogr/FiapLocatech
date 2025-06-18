package com.fiap.locatech.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(
        @NotNull(message = "o id da pessoa não pode ser nulo")
        Long pessoaId,
        @NotNull(message = "o id do veiculo não pode ser nulo")
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim) {

}