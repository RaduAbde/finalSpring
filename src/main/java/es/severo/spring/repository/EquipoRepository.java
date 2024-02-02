package es.severo.spring.repository;

import es.severo.spring.entity.Coche;
import es.severo.spring.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipoRepository extends JpaRepository<Equipo,Long> {
    List<Equipo> findByCompeticion(String competicion);

    List<Equipo> findByEstrategia_Neumaticos(String neumaticos);


    @Override
    Optional<Equipo> findById(Long aLong);
}
