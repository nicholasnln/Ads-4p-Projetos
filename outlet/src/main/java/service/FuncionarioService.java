package service;

import entity.Funcionario;
import repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public Optional<Funcionario> findByIdOptional(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> findByIdadeGreaterThanEqual(Integer idade) {
        return funcionarioRepository.findByIdadeGreaterThanEqual(idade);
    }

    public List<Funcionario> findByMatriculaContainingIgnoreCase(String matricula) {
        return funcionarioRepository.findByMatriculaContainingIgnoreCase(matricula);
    }

    public Funcionario findByMatricula(String matricula) {
        return funcionarioRepository.findByMatricula(matricula);
    }

    public List<Funcionario> findByNomeContainingIgnoreCase(String nome) {
        return funcionarioRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Funcionario> findByIdadeBetween(Integer startAge, Integer endAge) {
        return funcionarioRepository.findByIdadeBetween(startAge, endAge);
    }
}
