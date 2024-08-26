package service;

import entity.Venda;
import repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }

    public List<Venda> findByValorTotalGreaterThan(Double valorTotal) {
        return vendaRepository.findByValorTotalGreaterThan(valorTotal);
    }

    public List<Venda> findByEnderecoEntregaContainingIgnoreCase(String enderecoEntrega) {
        return vendaRepository.findByEnderecoEntregaContainingIgnoreCase(enderecoEntrega);
    }

    public List<Venda> findByClienteNomeContainingIgnoreCase(String nomeCliente) {
        return vendaRepository.findByClienteNomeContainingIgnoreCase(nomeCliente);
    }
}
