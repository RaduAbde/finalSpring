package es.severo.spring.repository;

import es.severo.spring.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CocheRepository extends JpaRepository<Coche,String> {

    @Transactional
    @Modifying
    @Query("update Coche c set c.potencia = ?1 where c.matricula = ?2")
    int updatePotenciaByMatricula(Integer potencia, String matricula);


    Coche findFirstByOrderByPotenciaDesc();

    List<Coche> findByPotenciaGreaterThanEqual(Integer potencia);

    Coche findByMatricula(String matricula);










}
