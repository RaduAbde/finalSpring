package es.severo.spring.service;

import es.severo.spring.entity.Equipo;
import es.severo.spring.repository.EquipoRepository;
import es.severo.spring.util.CamposEquipo;
import es.severo.spring.util.Competicion;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> findAll(){
        return equipoRepository.findAll();
    }

    public List<Equipo> findAllSplited(Integer pageNo, Integer pageSize, CamposEquipo camposEquipo, Sort.Direction sortDirection){
        //Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize, Sort.by(sortDirection,camposEquipo.getStr()));
        return equipoRepository.findAll(pageable).getContent();
    }

    public List<Equipo> findByCompeticion(String competicion){
        return equipoRepository.findByCompeticion(competicion);
    }

    public List<Equipo> findByTiresUsed(String neumaticos){
        return equipoRepository.findByEstrategia_Neumaticos(neumaticos);
    }
}
