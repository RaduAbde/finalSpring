package es.severo.spring.repository;

import es.severo.spring.entity.Coche;
import es.severo.spring.entity.Estrategia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstrategiaRepository extends JpaRepository<Estrategia,Long> {
}
