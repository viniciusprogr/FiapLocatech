package com.fiap.locatech.controllers;

import com.fiap.locatech.dtos.AluguelRequestDTO;
import com.fiap.locatech.entities.Aluguel;



import com.fiap.locatech.services.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    // http://localhost:8080/pessoas?page=1&size=10

    @Operation(
            description = "Busca todos os pessoas paginados",
            summary = "Busca de pessoas",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )


    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAlugueis(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("/alugueis");
        var alugueis = this.aluguelService.findAllAlugueis(page, size);
        return ResponseEntity.ok(alugueis);
    }


    // http://localhost:8080/pessoas/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findAluguelById(
            @PathVariable("id") Long id
    ) {
        logger.info("/aluguels/"+ id);
        var aluguel = this.aluguelService.findAluguelById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> saveAluguel(
           @Valid @RequestBody AluguelRequestDTO aluguel
    ) {
        logger.info("POST -> /aluguels");
        this.aluguelService.saveAluguel(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatealuguel(
            @PathVariable("id") Long id,
            @RequestBody Aluguel aluguel
    ) {
        logger.info("PUT -> /aluguels/"+ id);
        this.aluguelService.updateAluguel(aluguel, id);
        var status = HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status.value()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletealuguel(
            @PathVariable("id") Long id
    ) {
        logger.info("DELETE -> /aluguels/"+ id);
        this.aluguelService.deleteAluguel(id);
        return ResponseEntity.ok().build();
    }


}
