package controller;

import entity.Funcionario;
import service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public Funcionario findById(@PathVariable Long id) {
        return funcionarioService.findById(id);
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        funcionarioService.delete(id);
    }

    @PutMapping("/{id}")
    public Funcionario update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario existingFuncionario = funcionarioService.findById(id);
        if (existingFuncionario != null) {
            funcionario.setId(id);  // Mantém o mesmo ID
            return funcionarioService.save(funcionario);
        }
        return null; // Ou lançar uma exceção, caso o funcionário não seja encontrado
    }

    @GetMapping("/buscar/nome")
    public List<Funcionario> findByNome(@RequestParam String nome) {
        return funcionarioService.findByNome(nome);
    }

    @GetMapping("/buscar/idade")
    public List<Funcionario> findByIdadeGreaterThanEqual(@RequestParam Integer idade) {
        return funcionarioService.findByIdadeGreaterThanEqual(idade);
    }

    @GetMapping("/buscar/matricula")
    public List<Funcionario> findByMatricula(@RequestParam String matricula) {
        return funcionarioService.findByMatriculaContainingIgnoreCase(matricula);
    }

    @GetMapping("/buscar/nome/contendo")
    public List<Funcionario> findByNomeContainingIgnoreCase(@RequestParam String nome) {
        return funcionarioService.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/buscar/idade/between")
    public List<Funcionario> findByIdadeBetween(@RequestParam Integer startAge, @RequestParam Integer endAge) {
        return funcionarioService.findByIdadeBetween(startAge, endAge);
    }
}
