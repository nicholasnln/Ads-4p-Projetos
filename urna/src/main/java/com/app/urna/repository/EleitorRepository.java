package com.app.urna.repository;

import com.urnavirtual.app.entity.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
}
