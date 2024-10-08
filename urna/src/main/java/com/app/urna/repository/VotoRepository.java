package com.app.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.urna.entity.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    @Query("SELECT COUNT(v) FROM Voto v WHERE v.prefeito.id = :candidatoId OR v.vereador.id = :candidatoId")
    long countVotosByCandidatoId(@Param("candidatoId") Long candidatoId);

    @Query("SELECT COUNT(v) FROM Voto v")
    long countTotalVotos();

}
