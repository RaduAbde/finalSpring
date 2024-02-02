package es.severo.spring.controller;

import es.severo.spring.entity.Coche;
import es.severo.spring.entity.Piloto;
import es.severo.spring.service.CocheService;
import es.severo.spring.util.CamposCoche;
import es.severo.spring.util.DriverStyle;
import es.severo.spring.util.Marcas;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CAR TABLE")
@RestController
@RequestMapping("/api")
public class CocheRestController implements CarApi{

    private final CocheService cocheService;

    public CocheRestController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @GetMapping("/cars")
    public List<Coche> getCars(){
        return cocheService.findAll();
    }

    @GetMapping("/carsspaged")
    public List<Coche> getPagedDrivers(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue ="3") Integer pageSize,
                                        @RequestParam(required = false) CamposCoche camposCoche,
                                        @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection){
        return cocheService.findAllSplited(pageNo,pageSize,camposCoche,sortDirection);
    }

    @GetMapping("/fastestcar")
    public Coche getFastestCar(){
        return cocheService.findFastest();
    }

    @PostMapping("/car")
    public Coche newCar(@RequestParam(name ="Matricula") String matricula,@RequestParam(name ="Marca") String marca,@RequestParam(name ="Modelo") String modelo,@RequestParam(name ="Potencia") Integer potencia){
        Coche coche = new Coche();
        coche.setMatricula(matricula);
        coche.setMarca(marca);
        coche.setModelo(modelo);
        coche.setPotencia(potencia);
        return cocheService.create(coche);
    }

    @GetMapping("cars/over/{hp}")
    public List<Coche> getCarsOverAndEqualHP(@PathVariable("hp") Integer potencia){
        return cocheService.getCarsOverOrEqualHP(potencia);
    }

    @DeleteMapping("/delete/car/{matricula}")
    public ResponseEntity<String> delete(@PathVariable String matricula){
        cocheService.delete(matricula);
        return new ResponseEntity<>("Task deleted succesfully", HttpStatus.OK);
    }

    @PatchMapping("/car/patch/{matricula}/{potencia}")
    public ResponseEntity<Integer> update(@PathVariable("matricula") String matricula, @PathVariable("potencia") Integer potencia){

            Integer a = cocheService.updatePotenciaByMatricula(potencia,matricula);
            return new ResponseEntity<>(a, HttpStatus.OK);
    }

}
