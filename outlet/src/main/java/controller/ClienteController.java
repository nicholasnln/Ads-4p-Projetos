package controller;

import entity.Cliente;
import service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente existingCliente = clienteService.findById(id);
        if (existingCliente != null) {
            cliente.setId(id);  // Mantém o mesmo ID
            return clienteService.save(cliente);
        }
        return null; // Ou lançar uma exceção, caso o cliente não seja encontrado
    }

    @GetMapping("/buscar/nome")
    public List<Cliente> findByNome(@RequestParam String nome) {
        return clienteService.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/buscar/cpf")
    public List<Cliente> findByCpf(@RequestParam String cpf) {
        return clienteService.findByCpf(cpf);
    }

    @GetMapping("/buscar/idade")
    public List<Cliente> findClientesComIdadeMaiorOuIgual(@RequestParam int idade) {
        return clienteService.findClientesComIdadeMaiorOuIgual(idade);
    }
}
