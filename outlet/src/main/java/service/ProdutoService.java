package service;

import entity.Produto;
import repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> findByNomeContainingIgnoreCase(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produto> findByValorLessThanEqual(Double valor) {
        return produtoRepository.findByValorLessThanEqual(valor);
    }

    public List<Produto> findByNomeStartingWith(String prefix) {
        return produtoRepository.findByNomeStartingWith(prefix);
    }

    public List<Produto> findByValorBetween(Double valorMin, Double valorMax) {
        return produtoRepository.findByValorBetween(valorMin, valorMax);
    }
}
