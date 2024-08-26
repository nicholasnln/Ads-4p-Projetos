package repository;

import entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Consulta automática baseada no nome exato
    List<Funcionario> findByNome(String nome);

    // Consulta automática baseada em parte do nome, ignora maiúsculas/minúsculas
    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    // Consulta com JPQL para buscar funcionários com idade entre startAge e endAge
    @Query("SELECT f FROM Funcionario f WHERE f.idade BETWEEN :startAge AND :endAge")
    List<Funcionario> findByIdadeBetween(@Param("startAge") Integer startAge, @Param("endAge") Integer endAge);

    // Consulta automática baseada em parte da matrícula, ignora maiúsculas/minúsculas
    List<Funcionario> findByMatriculaContainingIgnoreCase(String matricula);

    // Consulta automática para encontrar um funcionário pela matrícula exata
    Funcionario findByMatricula(String matricula);

    // Consulta automática para encontrar funcionários com idade maior ou igual ao valor fornecido
    List<Funcionario> findByIdadeGreaterThanEqual(Integer idade);
}
