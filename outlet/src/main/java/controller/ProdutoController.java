package controller;

import entity.Produto;
import service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return produtoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) {
        Produto existingProduto = produtoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado para atualização"));
        produto.setId(id);
        return produtoService.save(produto);
    }

    @GetMapping("/buscar/nome")
    public List<Produto> findByNome(@RequestParam String nome) {
        return produtoService.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/buscar/valor/maior")
    public List<Produto> findByValorGreaterThanEqual(@RequestParam Double valor) {
        return produtoService.findByValorLessThanEqual(valor);
    }

    @GetMapping("/buscar/valor/between")
    public List<Produto> findByValorBetween(@RequestParam Double minValor, @RequestParam Double maxValor) {
        return produtoService.findByValorBetween(minValor, maxValor);
    }
}
