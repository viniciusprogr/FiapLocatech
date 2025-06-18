package com.fiap.locatech.services;



import com.fiap.locatech.dtos.AluguelRequestDTO;
import com.fiap.locatech.entities.Aluguel;
import com.fiap.locatech.repositories.AluguelRepository;
import com.fiap.locatech.repositories.AluguelRepository;
import com.fiap.locatech.repositories.PessoaRepository;
import com.fiap.locatech.repositories.VeiculoRepository;
import com.fiap.locatech.services.exeptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    public final AluguelRepository AluguelRepository;

    public final VeiculoRepository  VeiculoRepository;

    public AluguelService(AluguelRepository AluguelRepository, VeiculoRepository VeiculoRepository) {
        this.AluguelRepository = AluguelRepository;
        this.VeiculoRepository = VeiculoRepository;
    }

    public List<Aluguel> findAllAlugueis(int page, int size) {
        int offset = (page - 1) * size;
        return this.AluguelRepository.findAll(size, offset);
    }

    public Optional<Aluguel> findAluguelById(Long id) {
        return Optional.ofNullable(this.AluguelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado")));
    }

    public void saveAluguel(AluguelRequestDTO Aluguel) {
        var aluguelEntity = calculaAluguel(Aluguel);
        var save = this.AluguelRepository.save(aluguelEntity);
        Assert.state(save == 1, "Erro ao salvar veiculo" + Aluguel.pessoaId());
    }

    public void updateAluguel(Aluguel Aluguel, Long id) {
        var update = this.AluguelRepository.update(Aluguel, id);
        if (update == 0) {
            throw new RuntimeException("Erro ao atualizar veiculo" + Aluguel.getPessoaId());
        }
    }

    public void deleteAluguel(Long id) {
        var delete = this.AluguelRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Erro ao deletar veiculo" + id);
        }
    }

    private Aluguel calculaAluguel(AluguelRequestDTO aluguelRequestDTO) {
        var veiculo = this.VeiculoRepository.findById(aluguelRequestDTO.veiculoId())
                .orElseThrow(() -> new RuntimeException("veiculo não encontrado"));

        var quaridadeDias = BigDecimal.valueOf(aluguelRequestDTO.dataFim().getDayOfYear() - aluguelRequestDTO.dataInicio().getDayOfYear());

        var valor = veiculo.getValorDiaria().multiply(quaridadeDias);
        return new Aluguel(aluguelRequestDTO, valor);
    }
}
