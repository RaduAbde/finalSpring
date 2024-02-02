package es.severo.spring.service;

import es.severo.spring.entity.Piloto;
import es.severo.spring.repository.PilotoRepository;
import es.severo.spring.util.CamposPiloto;
import es.severo.spring.util.DriverStyle;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PilotoService {

    private final PilotoRepository pilotoRepository;

    public PilotoService(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    public List<Piloto> findAll(){
        return  pilotoRepository.findAll();
    }

    public List<Piloto> findAllPaged(Integer pageNo, Integer pageSize, CamposPiloto piloto, Sort.Direction sortDirection){
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize, Sort.by(sortDirection,piloto.getStr()));
        return pilotoRepository.findAll(pageable).getContent();
    }

    public long countDriversThatDriveCar(String marca){
        return pilotoRepository.countByCoche_Marca(marca);
    }

    public List<Piloto> findDriversThatBelongToATeam(String equipo){
        return pilotoRepository.findByEquipo_Nombre(equipo);
    }

    public void delete(String dni){
        pilotoRepository.deleteById(dni);
    }

    public List<Piloto> findByStyle(String style){
        return pilotoRepository.findByEstilo(style);
    }


}
