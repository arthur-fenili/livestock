package com.checkpoint.livestock.service;

import com.checkpoint.livestock.dto.request.ArmazemRequest;
import com.checkpoint.livestock.dto.response.ArmazemResponse;
import com.checkpoint.livestock.model.Armazem;
import com.checkpoint.livestock.repository.ArmazemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmazemService {

    private final ArmazemRepository armazemRepository;

    public ArmazemService(ArmazemRepository armazemRepository) {
        this.armazemRepository = armazemRepository;
    }

    public void cadastrarArmazem(ArmazemRequest dto) {
        Armazem armazem = new Armazem();
        armazem.setNomeArmazem(dto.getNomeArmazem());
        armazem.setEndereco(dto.getEndereco());
        armazem.setTelefone(dto.getTelefone());
        armazem.setNomeResponsavel(dto.getNomeResponsavel());

        armazemRepository.save(armazem);
    }

    public List<Armazem> listarArmazens() {
        return armazemRepository.findAll();
    }

    public ArmazemResponse buscarPorId(Long id) {
        Armazem armazem = armazemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Armazém não encontrado"));
        return toResponse(armazem);
    }

    public void deletarArmazem(Long id) {
        armazemRepository.deleteById(id);
    }

    public void atualizarArmazem(Long id, ArmazemRequest dto) {
        Armazem armazem = armazemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Armazém não encontrado"));

        armazem.setNomeArmazem(dto.getNomeArmazem());
        armazem.setEndereco(dto.getEndereco());
        armazem.setTelefone(dto.getTelefone());
        armazem.setNomeResponsavel(dto.getNomeResponsavel());

        armazemRepository.save(armazem);
    }

    private ArmazemResponse toResponse(Armazem armazem) {
        return new ArmazemResponse(
                armazem.getId(),
                armazem.getNomeArmazem(),
                armazem.getEndereco(),
                armazem.getTelefone(),
                armazem.getNomeResponsavel()
        );
    }
}
