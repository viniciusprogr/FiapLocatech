package com.fiap.locatech.dtos;

import java.util.List;

public record ValidationErrorDTO(List<String> errors, int status) {

}
