package es.severo.spring.service;

import es.severo.spring.entity.Coche;
import es.severo.spring.repository.CocheRepository;
import es.severo.spring.util.CamposCoche;
import es.severo.spring.util.Marcas;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {

    private final CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public List<Coche> findAll(){
        return cocheRepository.findAll();
    }

    public Coche create(Coche c){
        return cocheRepository.save(c);
    }

    public int updatePotenciaByMatricula(int potencia,String matricula){
        return cocheRepository.updatePotenciaByMatricula(potencia,matricula);
    }

    public void delete(String matricula){
        cocheRepository.deleteById(matricula);
    }

    public Coche findByMatricula(String matricula){
        return cocheRepository.findByMatricula(matricula);
    }
    public List<Coche> findAllSplited(Integer pageNo, Integer pageSize, CamposCoche camposCoche, Sort.Direction sortDirection){
        //Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize, Sort.by(sortDirection,camposCoche.getStr()));
        return cocheRepository.findAll(pageable).getContent();
    }

    public List<Coche> getCarsOverOrEqualHP(Integer potencia){
        return cocheRepository.findByPotenciaGreaterThanEqual(potencia);
    }

    public Coche findFastest(){
        return cocheRepository.findFirstByOrderByPotenciaDesc();
    }
}
