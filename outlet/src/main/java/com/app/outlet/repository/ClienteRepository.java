package com.app.outlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.outlet.entity.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByCpf(String cpf);//procura cliente pelo cpf

    List<Cliente> findByIdadeGreaterThanEqual(Integer idade);//procura cliente pela idade

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> findByNomeContainingIgnoreCase(@Param("nome") String nome);//mostra uma lista de nomes não sensivel a maiusculas igual ao passado no parametro
}