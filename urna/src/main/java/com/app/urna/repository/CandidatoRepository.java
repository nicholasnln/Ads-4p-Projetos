package com.app.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.urna.entity.Candidato;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
