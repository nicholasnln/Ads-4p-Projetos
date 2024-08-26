package service;

import entity.Cliente;
import repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> findByIdadeGreaterThanEqual(Integer idade) {
        return clienteRepository.findByIdadeGreaterThanEqual(idade);
    }

    public List<Cliente> findByNomeContainingIgnoreCase(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Novo método para consulta por idade
    public List<Cliente> findClientesComIdadeMaiorOuIgual(int idade) {
        return clienteRepository.findByIdadeGreaterThanEqual(idade);
    }
}
