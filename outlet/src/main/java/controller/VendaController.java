package controller;

import entity.Venda;
import service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> findAll() {
        return vendaService.findAll();
    }

    @GetMapping("/{id}")
    public Venda findById(@PathVariable Long id) {
        return vendaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    @PostMapping
    public Venda save(@RequestBody Venda venda) {
        return vendaService.save(venda);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vendaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Venda update(@PathVariable Long id, @RequestBody Venda venda) {
        Venda existingVenda = vendaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada para atualização"));
        venda.setId(id);  // Certifique-se de que o método setId está definido na classe Venda
        return vendaService.save(venda);
    }

    @GetMapping("/buscar/valor/maior")
    public List<Venda> findByValorTotalGreaterThan(@RequestParam Double valorTotal) {
        return vendaService.findByValorTotalGreaterThan(valorTotal);
    }

    @GetMapping("/buscar/endereco")
    public List<Venda> findByEnderecoEntregaContainingIgnoreCase(@RequestParam String enderecoEntrega) {
        return vendaService.findByEnderecoEntregaContainingIgnoreCase(enderecoEntrega);
    }

    @GetMapping("/buscar/cliente")
    public List<Venda> findByClienteNomeContainingIgnoreCase(@RequestParam String nomeCliente) {
        return vendaService.findByClienteNomeContainingIgnoreCase(nomeCliente);
    }
}
