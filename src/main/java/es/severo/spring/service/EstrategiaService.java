package es.severo.spring.service;

import es.severo.spring.entity.Estrategia;
import es.severo.spring.repository.EstrategiaRepository;
import es.severo.spring.util.CamposEstrategia;
import es.severo.spring.util.Neumaticos;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstrategiaService {

    private final EstrategiaRepository estrategiaRepository;

    public EstrategiaService(EstrategiaRepository estrategiaRepository) {
        this.estrategiaRepository = estrategiaRepository;
    }

    public List<Estrategia> findAll(){
       return estrategiaRepository.findAll();
    }

    public Estrategia create(Estrategia e){
        return estrategiaRepository.save(e);
    }

    public List<Estrategia> findAllSplited(Integer pageNo, Integer pageSize, CamposEstrategia camposEstrategia, Sort.Direction sortDirection){
        //Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize, Sort.by(sortDirection,camposEstrategia.getStr()));
        return estrategiaRepository.findAll(pageable).getContent();
    }




}
