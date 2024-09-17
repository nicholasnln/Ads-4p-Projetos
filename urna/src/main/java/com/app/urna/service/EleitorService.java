package com.app.urna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.urna.entity.Eleitor;
import com.app.urna.repository.EleitorRepository;

@Service
public class EleitorService {
	@Autowired
    private EleitorRepository eleitorRepository;

    public Eleitor salvar(Eleitor eleitor) {
        if (eleitor.getCpf() == null || eleitor.getEmail() == null) {
            eleitor.setStatus(StatusEleitor.PENDENTE);
        } else {
            eleitor.setStatus(StatusEleitor.APTO);
        }
        return eleitorRepository.save(eleitor);
    }

    public List<Eleitor> listarAtivos() {
        return eleitorRepository.findAllByStatusNot(StatusEleitor.INATIVO);
    }

    public Optional<Eleitor> buscarPorId(Long id) {
        return eleitorRepository.findById(id);
    }

    public Eleitor atualizar(Long id, Eleitor eleitorAtualizado) throws Exception {
        Eleitor existente = buscarPorId(id).orElseThrow(() -> new Exception("Eleitor não encontrado"));
        // Atualizar campos conforme necessário
        existente.setNomeCompleto(eleitorAtualizado.getNomeCompleto());
        existente.setCpf(eleitorAtualizado.getCpf());
        existente.setProfissao(eleitorAtualizado.getProfissao());
        existente.setTelefoneCelular(eleitorAtualizado.getTelefoneCelular());
        existente.setTelefoneFixo(eleitorAtualizado.getTelefoneFixo());
        existente.setEmail(eleitorAtualizado.getEmail());
        if (eleitorAtualizado.getCpf() == null || eleitorAtualizado.getEmail() == null) {
            existente.setStatus(StatusEleitor.PENDENTE);
        } else {
            existente.setStatus(StatusEleitor.APTO);
        }
        return eleitorRepository.save(existente);
    }

    public void deletar(Long id) throws Exception {
        Eleitor eleitor = buscarPorId(id).orElseThrow(() -> new Exception("Eleitor não encontrado"));
        if (eleitor.getStatus() == StatusEleitor.VOTOU) {
            throw new Exception("Usuário já votou. Não foi possível inativá-lo");
        }
        eleitor.setStatus(StatusEleitor.INATIVO);
        eleitorRepository.save(eleitor);
    }
}
