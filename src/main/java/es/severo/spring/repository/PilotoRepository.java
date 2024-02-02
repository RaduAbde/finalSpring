package es.severo.spring.repository;

import es.severo.spring.entity.Coche;
import es.severo.spring.entity.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PilotoRepository extends JpaRepository<Piloto,String> {
    long countByCoche_Marca(String marca);

    List<Piloto> findByEquipo_Nombre(String nombre);

    List<Piloto> findByEstilo(String estilo);







}
