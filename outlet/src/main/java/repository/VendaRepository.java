package repository;

import entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    // Consulta JPQL para buscar vendas com valor total maior que um valor específico
    @Query("SELECT v FROM Venda v WHERE v.valorTotal > :valorTotal")
    List<Venda> findByValorTotalGreaterThan(@Param("valorTotal") Double valorTotal);

    // Método automático para buscar vendas pelo endereço de entrega
    List<Venda> findByEnderecoEntregaContainingIgnoreCase(String enderecoEntrega);

    // Método automático para buscar vendas por cliente (assumindo que Cliente tem um atributo 'nome')
    List<Venda> findByClienteNomeContainingIgnoreCase(String nomeCliente);
}
