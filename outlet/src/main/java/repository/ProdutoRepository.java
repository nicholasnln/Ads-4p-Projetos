package repository;

import entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Método automático para buscar produtos com valor menor ou igual ao valor fornecido
    List<Produto> findByValorLessThanEqual(Double valor);

    // Método automático para buscar produtos cujo nome começa com o prefixo fornecido
    List<Produto> findByNomeStartingWith(String prefix);

    // Consulta JPQL para buscar produtos cujo nome contenha o texto fornecido, ignorando maiúsculas/minúsculas
    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Produto> findByNomeContainingIgnoreCase(@Param("nome") String nome);

    // Método para buscar produtos com valor entre dois limites
    List<Produto> findByValorBetween(Double valorMin, Double valorMax);
}
